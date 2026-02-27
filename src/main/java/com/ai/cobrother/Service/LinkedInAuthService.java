package com.ai.cobrother.Service;

import com.ai.cobrother.Model.LinkedInUserData;
import com.ai.cobrother.Model.User;
import com.ai.cobrother.Repository.UserRepository;
import com.ai.cobrother.Security.JwtUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@Service
public class LinkedInAuthService {

    @Value("${linkedin.client.id}")
    private String clientId;

    @Value("${linkedin.client.secret}")
    private String clientSecret;

    @Value("${linkedin.redirect.uri}")
    private String redirectUri;

    private final UserRepository userRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate = new RestTemplate();

    public LinkedInAuthService(UserRepository repo,
                               JwtUtil jwtUtil,
                               PasswordEncoder passwordEncoder) {
        this.userRepo = repo;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ STEP 1 — Exchange code for access token
    public String getAccessToken(String code) {

        System.out.println("===== LINKEDIN DEBUG =====");
        System.out.println("CODE = " + code);
        System.out.println("CLIENT_ID = " );
        System.out.println("REDIRECT_URI = " );
        System.out.println("===========================");

        String url = "https://www.linkedin.com/oauth/v2/accessToken";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("code", code);
        body.add("redirect_uri", redirectUri);
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, request, Map.class);

        if (response.getBody() == null)
            throw new RuntimeException("LinkedIn token response empty");

        return (String) response.getBody().get("access_token");
    }

    // ✅ STEP 2 — Get LinkedIn profile
    public LinkedInUserData getProfile(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(
                        "https://api.linkedin.com/v2/userinfo",
                        HttpMethod.GET,
                        entity,
                        Map.class
                );

        Map body = response.getBody();

        LinkedInUserData data = new LinkedInUserData();
        data.setId((String) body.get("sub"));
        data.setEmail((String) body.get("email"));
        data.setFirstName((String) body.get("given_name"));
        data.setLastName((String) body.get("family_name"));

        return data;
    }

    // ✅ STEP 3 — Login or Register LinkedIn user
    public String loginOrRegister(LinkedInUserData profile) {

        User user = userRepo.findByUsername(profile.getEmail())
                .orElseGet(() -> {

                    User newUser = new User();
                    newUser.setUsername(profile.getEmail());

                    // 🔥 Mark as LINKEDIN user
                    newUser.setProvider("LINKEDIN");

                    // Generate random encrypted password
                    newUser.setPassword(
                            passwordEncoder.encode(UUID.randomUUID().toString())
                    );

                    return userRepo.save(newUser);
                });

        // 🔥 If existing user is LOCAL, allow login (optional safety)
        // If you want to block it, tell me.

        // ✅ STEP 4 — Generate JWT
        return jwtUtil.generateToken(user.getUsername());
    }



//    @PostConstruct
//    public void test(){
//        System.out.println("ID=" + clientId);
//        System.out.println("SECRET=" + clientSecret);
//        System.out.println("URI=" + redirectUri);
//    }
}