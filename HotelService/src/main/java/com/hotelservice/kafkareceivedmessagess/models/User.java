package com.hotelservice.kafkareceivedmessagess.models;

import lombok.Data;

@Data
public class User {
	private String id;
    
    private String username;
    private String email;
    private String password;
    private String role;
}
