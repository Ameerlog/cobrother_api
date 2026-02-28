package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.LinkedInAuthResponse;
import com.ai.cobrother.Model.LinkedInUserData;
import com.ai.cobrother.Model.User;
import com.ai.cobrother.Security.JwtUtil;
import com.ai.cobrother.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
}