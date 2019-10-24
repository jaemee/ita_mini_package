package com.tw.itamnl.minipackage.repository;

import com.tw.itamnl.minipackage.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
