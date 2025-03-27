package com.usersservice.models;




import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;


@Data
public class Hotel implements Serializable {

	
	
    
    private String name;
    private String location;
    private String rating;
//    private int numberOfRoomsAvailable;
//   private String number;
}

