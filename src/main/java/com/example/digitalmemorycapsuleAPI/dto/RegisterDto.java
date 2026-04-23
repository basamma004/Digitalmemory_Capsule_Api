package com.example.digitalmemorycapsuleAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDto {

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password is required")
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

//1. User logs in
//↓
//2. Server checks email + password
//↓
//3. Server creates JWT token
//↓
//4. Client receives token
//↓
//5. Client sends token in every request
//↓
//6. Server validates token → allows access