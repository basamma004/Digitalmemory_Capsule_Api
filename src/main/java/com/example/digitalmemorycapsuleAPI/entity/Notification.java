package com.example.digitalmemorycapsuleAPI.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "capsule_id")
    private Capsule capsule;

    private String status;
    private LocalDateTime sentTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Capsule getCapsule() {
		return capsule;
	}
	public void setCapsule(Capsule capsule) {
		this.capsule = capsule;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getSentTime() {
		return sentTime;
	}
	public void setSentTime(LocalDateTime sentTime) {
		this.sentTime = sentTime;
	}
}