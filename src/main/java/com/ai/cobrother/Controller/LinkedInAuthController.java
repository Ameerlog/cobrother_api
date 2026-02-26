package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.LinkedInUserData;
import com.ai.cobrother.Service.LinkedInAuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LinkedInAuthController {

    private final LinkedInAuthService linkedInAuthService;

    @Value("${linkedin.client.id}")
    private String clientId;

    @Value("${linkedin.redirect.uri}")
    private String redirectUri;

    public LinkedInAuthController(LinkedInAuthService service) {
        this.linkedInAuthService = service;
    }

    // ✅ STEP 1 — Redirect to LinkedIn login
    @GetMapping("/linkedin")
    public void redirectToLinkedIn(HttpServletResponse response) throws IOException {

        String linkedinAuthUrl =
                "https://www.linkedin.com/oauth/v2/authorization" +
                        "?response_type=code" +
                        "&client_id="  +
                        "&redirect_uri="  +
                        "&scope=openid profile email";

        response.sendRedirect(linkedinAuthUrl);
    }

    // ✅ STEP 2 — Handle callback
//    @GetMapping("/linkedin/callback")
//    public ResponseEntity<?> handleCallback(@RequestParam("code") String code) {
//
//        // 1️⃣ Get access token
//        String accessToken = linkedInAuthService.getAccessToken(code);
//
//        // 2️⃣ Get LinkedIn profile
//        LinkedInUserData profile =
//                linkedInAuthService.getProfile(accessToken);
//
//        // 3️⃣ Login or Register user
//        String jwtToken =
//                linkedInAuthService.loginOrRegister(profile);
//
//        // 4️⃣ Return JWT
//        Map<String, String> response = new HashMap<>();
//        response.put("token", jwtToken);
//
//        return ResponseEntity.ok(response);
//    }


    @GetMapping("/linkedin/callback")
    public void handleCallback(@RequestParam("code") String code, HttpServletResponse response) throws IOException {

        // 1️⃣ Get access token
        String accessToken = linkedInAuthService.getAccessToken(code);

        // 2️⃣ Get LinkedIn profile
        LinkedInUserData profile = linkedInAuthService.getProfile(accessToken);

        // 3️⃣ Login or Register user
        String jwtToken = linkedInAuthService.loginOrRegister(profile);

        // 4️⃣ Redirect to frontend with token in URL
        response.sendRedirect("http://192.168.29.186:3000/?token=" + jwtToken);
    }
}