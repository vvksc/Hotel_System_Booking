package com.usersservice.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class User implements Serializable{

	 @Id
		private String id;
	    
	    private String username;
	    private String email;
	    private String password;
	    private String role;
	    @Transient
	    
	    List<Booking> myBookings=new ArrayList<Booking>();
}
