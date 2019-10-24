package com.tw.itamnl.minipackage.controller;

import com.tw.itamnl.minipackage.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Package createPackageBooking(@RequestBody Package packageBooking){
        return packageService.save(packageBooking);
    }

}
