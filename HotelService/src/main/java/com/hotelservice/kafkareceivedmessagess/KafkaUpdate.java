package com.hotelservice.kafkareceivedmessagess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

// import com.hotelservice.kafkareceivedmessagess.models.User;
import com.hotelservice.models.Hotel;
import com.hotelservice.repo.HotelRepo;
// import com.hotelservice.service.HotelService;

@Configuration
public class KafkaUpdate {

	@Autowired
	private HotelRepo repo;
	
	@KafkaListener(topics = "USER_CREATED", groupId = "hotel_group")
	public void userCreated(String s) {
		
		System.out.println(s);
	}
	@KafkaListener(topics = "booking-events", groupId = "booking_group")
	public void bookingCreated(String s) {
		try {
			
			
			Hotel h=repo.findById(s).orElseThrow();
			int booked=h.getNumberOfRoomsAvailable();
			h.setNumberOfRoomsAvailable(--booked);
			repo.save(h);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@KafkaListener(topics = "booking-eventsinBulk", groupId = "booking_group")
	public void bookingCreatedInBulk(String s) {
		try {
			
			
			Hotel h=repo.findById(s).orElseThrow();
			int booked=h.getNumberOfRoomsAvailable();
			h.setNumberOfRoomsAvailable(--booked);
			repo.save(h);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	@KafkaListener(topics = "booking-cancelled", groupId = "booking_group")
	public void bookingCancelled(String s) {
		try {
			
			
			Hotel h=repo.findById(s).orElseThrow();
			int booked=h.getNumberOfRoomsAvailable();
			h.setNumberOfRoomsAvailable(++booked);
			repo.save(h);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
