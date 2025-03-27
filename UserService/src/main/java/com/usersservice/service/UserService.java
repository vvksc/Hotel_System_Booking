package com.usersservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.usersservice.exception.ResourceNotFoundException;
import com.usersservice.models.Booking;
import com.usersservice.models.Hotel;
import com.usersservice.models.User;
import com.usersservice.repo.UserRepo;
import com.usersservice.repo.projection.UserProjection;
import com.usersservice.service.feign.BookingService;
import com.usersservice.service.feign.HotelService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepo userRepo;
	private static int id=1001;
	
	List<UserProjection> l1;
	
	 @Autowired
	   private KafkaTemplate<String, String> kafkaTemplate;
	 
	 @Autowired
	 private BookingService bookingService;
	 
	 @Autowired
	 private HotelService service;
	
	public String createUser(User user) {
		
		if(user !=null) {
			user.setId(""+id++);
			userRepo.save(user);
			kafkaTemplate.send("USER_CREATED", "User created SUccesfully");
			
			return "user crated";
		}
		kafkaTemplate.send("USER_NOT_CREATED", "User not created");
		return "User not created";
	}
	public String saveAllUser(List<User> l) {
		for(User u:l)u.setId(""+ id++);
		userRepo.saveAll(l);
		return ""+l.size()+" user saved";
	}
	
	@Cacheable(value = "user", key = "#id")
	public User getUser(String id) {
		User u=userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException
						("By givind id user is not found "+id));
		List<Booking> book=bookingService.getBookings(id);
		
		log.warn(""+book);
		for(Booking i:book) {
			Hotel hotel=service.getHotelDetail(i.getHotelId());
			i.setHoteldetail(hotel);
			u.getMyBookings().add(i);
		}
		 l1=userRepo.findBy();
		
		return u;
		
	}
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public void delete(String id) {
		userRepo.delete(userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException
						("By givind id user is not found "+id)));
		kafkaTemplate.send("USER_DELETED", "User deleted :"+id);
	}
//	@Scheduled(fixedRate = 5000)
//	public void ask() {
//		log.warn(""+l1);
//		l1.forEach(user -> System.out.println(user.getId() + " - " + user.getusername()));
////		u.setMyBookings(book);
//	}
	
}
