package com.tw.itamnl.minipackage.controller;

import com.tw.itamnl.minipackage.dto.BookingDto;
import com.tw.itamnl.minipackage.model.Booking;
import com.tw.itamnl.minipackage.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    public Booking createPackageBooking(@RequestBody BookingDto booking){
        return bookingService.save(booking);
    }

    @GetMapping
    public Iterable<Booking> getAllBookings(){
        return bookingService.findAll();
    }
}
