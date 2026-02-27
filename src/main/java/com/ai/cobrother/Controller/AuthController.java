package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.LinkedInUserData;
import com.ai.cobrother.Model.User;
import com.ai.cobrother.Security.JwtUtil;
import com.ai.cobrother.Service.LinkedInAuthService;
import com.ai.cobrother.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private LinkedInAuthService linkedInService;

    // ✅ LOCAL REGISTER
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user) {

        String response = userService.register(user);

        return Map.of("message", response);
    }

    // ✅ LOCAL LOGIN
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User request) {

        User user = userService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

        String token = jwtUtil.generateToken(user.getUsername());

        return Map.of("token", token);
    }

    // ✅ LINKEDIN LOGIN
    @PostMapping("/linkedin")
    public Map<String, Object> linkedinLogin(@RequestBody Map<String, String> body) {

        String code = body.get("code");

        if (code == null || code.isEmpty()) {
            throw new RuntimeException("LinkedIn authorization code is missing");
        }

        // Step 1: Get access token
        String accessToken = linkedInService.getAccessToken(code);

        // Step 2: Get profile
        LinkedInUserData profile = linkedInService.getProfile(accessToken);

        // Step 3: Login or register user + generate JWT
        String jwt = linkedInService.loginOrRegister(profile);

        return Map.of(
                "token", jwt,
                "email", profile.getEmail(),
                "name", profile.getFirstName() + " " + profile.getLastName()
        );
    }
}