package com.example.digitalmemorycapsuleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalmemorycapsuleAPI.entity.Capsule;
import com.example.digitalmemorycapsuleAPI.entity.Message;
import com.example.digitalmemorycapsuleAPI.repository.CapsuleRepository;
import com.example.digitalmemorycapsuleAPI.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired private MessageRepository repo;
    @Autowired private CapsuleRepository capsuleRepo;

    public Message create(Message msg) {

        Long capsuleId = msg.getCapsule().getId();

        Capsule capsule = capsuleRepo.findById(capsuleId)
                .orElseThrow(() -> new RuntimeException("Capsule not found"));

        msg.setCapsule(capsule);

        return repo.save(msg);
    }

    public List<Message> getAll() {
        return repo.findAll();
    }
}
