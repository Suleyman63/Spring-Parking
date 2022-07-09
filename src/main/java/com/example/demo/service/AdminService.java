package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;

import java.util.List;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmin();

    Admin getAdminById(Long id);

    Admin editAdmin(Long id, Admin admin);

    Boolean deleteAdmin(Long id);

    Admin adminLogin(Admin admin);
}
