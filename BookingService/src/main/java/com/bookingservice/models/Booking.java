package com.bookingservice.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking implements Serializable{

	@Id
	private String id;
    
    private String userId;
    private String hotelId;
    
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    
    private String status; 
}
