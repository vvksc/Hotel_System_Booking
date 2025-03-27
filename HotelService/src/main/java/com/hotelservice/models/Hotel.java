package com.hotelservice.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Hotel implements Serializable{

	@Id
	private String id;
    
    private String name;
    private String location;
    private String rating;
    private int numberOfRoomsAvailable;
    @Transient
    private String number;
}
