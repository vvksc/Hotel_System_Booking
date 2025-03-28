package com.usersservice.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.usersservice.models.Booking;

@FeignClient(name="BOOKINGSERVICE")
public interface BookingService {

	 @GetMapping("/bookings/user/{userId}")
	 List<Booking>  getBookings(@PathVariable String userId);
	
	
}
