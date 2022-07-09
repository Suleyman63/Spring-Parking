package com.example.demo.controller;


import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        Admin result = adminService.saveAdmin(admin);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getAll")
    public List<Admin> getAllAdmin(){
        List<Admin> adminList = adminService.getAllAdmin();
        return  adminList;
    }
}
