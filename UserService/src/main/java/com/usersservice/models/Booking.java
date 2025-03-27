package com.usersservice.models;

import java.io.Serializable;
import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



@Data
public class Booking implements Serializable  {

	
	private String id;
    
    private String userId;
    private String hotelId;
    
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Hotel hoteldetail;
    private String status; 
}