package com.example.digitalmemorycapsuleAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalmemorycapsuleAPI.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
