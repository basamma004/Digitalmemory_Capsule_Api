package com.example.digitalmemorycapsuleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalmemorycapsuleAPI.entity.Notification;
import com.example.digitalmemorycapsuleAPI.service.NotificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired private NotificationService service;

    @PostMapping
    public Notification create(@RequestBody @Valid Notification notification) {
        return service.create(notification);
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }
}


