package com.ai.cobrother.Service;

import com.ai.cobrother.Model.User;
import com.ai.cobrother.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ REGISTER (LOCAL USERS ONLY)
    public String register(User user) {

        System.out.println("Registering user: " + user.getUsername());

        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists";
        }

        // 🔥 IMPORTANT: Set provider as LOCAL
        user.setProvider("LOCAL");

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        System.out.println("User saved with ID: " + savedUser.getId());

        return "User Registered Successfully";
    }

    // ✅ LOGIN (BLOCK LINKEDIN USERS FROM PASSWORD LOGIN)
    public User authenticate(String username, String password) {

        System.out.println("Authenticating user: " + username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 BLOCK LinkedIn users from password login
        if (!"LOCAL".equals(user.getProvider())) {
            throw new RuntimeException("Please login using LinkedIn");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        System.out.println("Login successful");

        return user;
    }
}