package com.example.digitalmemorycapsuleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalmemorycapsuleAPI.dto.LoginDto;
import com.example.digitalmemorycapsuleAPI.dto.RegisterDto;
import com.example.digitalmemorycapsuleAPI.entity.User;
import com.example.digitalmemorycapsuleAPI.repository.UserRepository;
import com.example.digitalmemorycapsuleAPI.util.PasswordUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordUtil passwordUtil;

    public User register(RegisterDto dto) {

        if (repo.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(dto.getEmail());

        // 🔐 FIXED
        user.setPassword(passwordUtil.encrypt(dto.getPassword()));

        return repo.save(user);
    }

    public String login(LoginDto dto) {

        User user = repo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔐 FIXED
        if (!passwordUtil.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login Successful";
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}