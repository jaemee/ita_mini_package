package com.tw.itamnl.minipackage.service;

import com.tw.itamnl.minipackage.model.Booking;
import com.tw.itamnl.minipackage.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    public Booking save(Booking booking) {
        return bookingRepo.save(booking);
    }

    public Iterable<Booking> findAll() {
        return bookingRepo.findAll();
    }
}
