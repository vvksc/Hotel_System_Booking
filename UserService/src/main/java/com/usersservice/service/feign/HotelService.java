package com.usersservice.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.usersservice.models.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {

	@GetMapping("hotels/{id}")
	Hotel getHotelDetail(@PathVariable String id);
}
