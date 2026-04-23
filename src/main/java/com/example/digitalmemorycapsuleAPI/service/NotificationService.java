package com.example.digitalmemorycapsuleAPI.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalmemorycapsuleAPI.entity.Capsule;
import com.example.digitalmemorycapsuleAPI.entity.Notification;
import com.example.digitalmemorycapsuleAPI.repository.CapsuleRepository;
import com.example.digitalmemorycapsuleAPI.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repo;

    @Autowired
    private CapsuleRepository capsuleRepo;

    // CREATE NOTIFICATION
    public Notification create(Notification notification) {

        // 1. Get capsule id from request
        Long capsuleId = notification.getCapsule().getId();

        // 2. Fetch capsule from DB
        Capsule capsule = capsuleRepo.findById(capsuleId)
                .orElseThrow(() -> new RuntimeException("Capsule not found"));

        // 3. Attach managed capsule object
        notification.setCapsule(capsule);

        // 4. OPTIONAL: set system fields (important fix for null issue)
        notification.setSentTime(LocalDateTime.now());
        notification.setStatus("SENT");

        // 5. Save to DB
        return repo.save(notification);
    }

    // GET ALL NOTIFICATIONS
    public List<Notification> getAll() {
        return repo.findAll();
    }
}