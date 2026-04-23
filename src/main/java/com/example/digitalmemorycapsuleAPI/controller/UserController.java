package com.example.digitalmemorycapsuleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.digitalmemorycapsuleAPI.dto.LoginDto;
import com.example.digitalmemorycapsuleAPI.dto.RegisterDto;
import com.example.digitalmemorycapsuleAPI.entity.User;
import com.example.digitalmemorycapsuleAPI.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody @Valid RegisterDto dto) {
        return service.register(dto);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginDto dto) {
        return service.login(dto);
    }

    // ✅ CREATE USER (normal CRUD)
    @PostMapping
    public User create(@RequestBody @Valid User user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "Deleted";
    }
}