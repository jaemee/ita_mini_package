package com.tw.itamnl.minipackage.controller;

import com.tw.itamnl.minipackage.model.Booking;
import com.tw.itamnl.minipackage.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private PackageService packageService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    public Booking createPackageBooking(@RequestBody Booking booking){
        return packageService.save(booking);
    }

    @GetMapping
    @ResponseStatus(code = CREATED)
    public Iterable<Booking> getAllBookings(){
        return packageService.findAll();
    }
}
