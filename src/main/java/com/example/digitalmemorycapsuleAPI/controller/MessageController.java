package com.example.digitalmemorycapsuleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalmemorycapsuleAPI.entity.Message;
import com.example.digitalmemorycapsuleAPI.service.MessageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired private MessageService service;

    @PostMapping
    public Message create(@RequestBody @Valid Message msg) {
        return service.create(msg);
    }

    @GetMapping
    public List<Message> getAll() {
        return service.getAll();
    }
}
