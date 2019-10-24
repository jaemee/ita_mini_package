package com.tw.itamnl.minipackage.service;

import com.tw.itamnl.minipackage.dto.BookingDto;
import com.tw.itamnl.minipackage.model.Booking;
import com.tw.itamnl.minipackage.model.PackageReceiver;
import com.tw.itamnl.minipackage.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    public Booking save(BookingDto bookingDto) {
        Booking booking = new Booking();
        PackageReceiver receiver = new PackageReceiver();
        receiver.setName(bookingDto.getReceiver());
        receiver.setPhoneNumber(bookingDto.getPhoneNumber());


        booking.setId(bookingDto.getId());
        booking.setPackageNo(bookingDto.getPackageNo());
        booking.setWeight(bookingDto.getWeight());
        booking.setReceiver(receiver);
        booking.setBookingTime(getCurrentTime());
        return bookingRepo.save(booking);
    }

    public Iterable<Booking> findAll() {
        return bookingRepo.findAll();
    }

    private LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

}
