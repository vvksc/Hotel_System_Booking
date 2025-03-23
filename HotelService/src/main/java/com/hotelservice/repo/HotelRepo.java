package com.hotelservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelservice.models.Hotel;
@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
