package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.model.Park;
import com.example.demo.service.AdminService;
import com.example.demo.service.ParkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/park")
public class ParkController {


    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }


    @GetMapping("/getPark")
    public List<Park> getAllEmployee(){
        List<Park> parkList = parkService.getPark();
        return  parkList;
    }

}
