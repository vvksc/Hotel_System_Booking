package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookingservice.models.Booking;
import com.bookingservice.service.BookingService;

import java.util.List;


@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
    @PostMapping("/all")
    public int createListBooking(@RequestBody List<Booking> booking) {
        return bookingService.createListBooking(booking);
    }

    @DeleteMapping("/{id}")
    public String cancelBooking(@PathVariable String id) {
        bookingService.cancelBooking(id);
        return "Booking " + id + " cancelled";
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable String id) {
        return bookingService.getBookingById(id);
    }
    @GetMapping
    public List<Booking> getAllBookings(){
    	return bookingService.getAllBookings();
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable String userId) {
        return bookingService.getBookingsByUserId(userId);
    }
    
    @GetMapping("/hotel/{hotelId}")
    public List<Booking> getBookingsByHotel(@PathVariable String hotelId) {
        return bookingService.getBookingsByHotelId(hotelId);
    }
}

