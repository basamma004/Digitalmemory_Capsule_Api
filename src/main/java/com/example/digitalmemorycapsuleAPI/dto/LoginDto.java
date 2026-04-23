package com.example.digitalmemorycapsuleAPI.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}

//{ its for user/rgister
//	  "email": "user1@gmail.com",
//	  "password": "123456"
//	}

//{  for user/login
//	  "email": "user1@gmail.com",
//	  "password": "123456"
//	}



//{    for Capsuels
//	  "user": {
//	    "id": 1
//	  },
//	  "unlockTime": "2026-12-31T10:00:00",
//	  "unlocked": false
//	}


//{   for notification
//	  "message": "Your capsule unlocks soon!",
//	  "capsule": {
//	    "id": 1
//	  }
//	}

//{   for message
//	  "encryptedText": "U2FsdGVkX1+abc123EncryptedData",
//	  "capsule": {
//	    "id": 1
//	  }
//	}