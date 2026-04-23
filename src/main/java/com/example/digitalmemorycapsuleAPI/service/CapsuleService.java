package com.example.digitalmemorycapsuleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalmemorycapsuleAPI.entity.Capsule;
import com.example.digitalmemorycapsuleAPI.entity.User;
import com.example.digitalmemorycapsuleAPI.repository.CapsuleRepository;
import com.example.digitalmemorycapsuleAPI.repository.UserRepository;

@Service
public class CapsuleService {

    @Autowired private CapsuleRepository repo;
    @Autowired private UserRepository userRepo;

    public Capsule create(Capsule capsule) {

    	Long userId = capsule.getUser().getId(); 

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        capsule.setUser(user);

        return repo.save(capsule);
    }

    public List<Capsule> getAll() {
        return repo.findAll();
    }
}
