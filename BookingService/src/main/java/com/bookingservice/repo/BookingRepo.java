package com.bookingservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingservice.models.Booking;

public interface BookingRepo extends JpaRepository<Booking, String> {

	
	 List<Booking> findByUserId(String userId);
	  List<Booking> findByHotelId(String hotelId);
}
