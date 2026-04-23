package com.example.digitalmemorycapsuleAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalmemorycapsuleAPI.entity.Capsule;
import com.example.digitalmemorycapsuleAPI.service.CapsuleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/capsules")
public class CapsuleController {

    @Autowired private CapsuleService service;

    @PostMapping
    public Capsule create(@RequestBody @Valid Capsule capsule) {
        return service.create(capsule);
    }

    @GetMapping
    public List<Capsule> getAll() {
        return service.getAll();
    }
}
