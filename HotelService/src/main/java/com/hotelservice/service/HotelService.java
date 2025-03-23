
package com.hotelservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.models.Hotel;
import com.hotelservice.repo.HotelRepo;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;
    private static int id=5001;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String createHotel(Hotel hotel) {
        if (hotel != null) {
        	hotel.setId(""+id++);
        	hotel.setNumberOfRoomsAvailable(10);
            hotelRepo.save(hotel);
            kafkaTemplate.send("HOTEL_CREATED", "Hotel has been created");
            return "Hotel created";
        }
        kafkaTemplate.send("HOTEL_NOT_CREATED", "Hotel creation failed");
        return "Hotel not created";
    }

    @Cacheable(value = "hotel", key = "#id")
    public Hotel getHotel(String id) {
        return hotelRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));
    }

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    public void deleteHotel(String id) {
        Hotel hotel = hotelRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));
        hotelRepo.delete(hotel);
        kafkaTemplate.send("HOTEL_DELETED", "Hotel has been deleted");
    }
    
    public String saveAllHotel(List<Hotel> h) {
    	for(Hotel i:h)i.setId(""+id++);
    	hotelRepo.saveAll(h);
    	return ""+h.size();
    }
}
