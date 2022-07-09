package com.example.demo.service.imp;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;

import java.util.List;
import java.util.Optional;

public class AdminServiceImp implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImp(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Long id) {

        Optional<Admin> adminList = adminRepository.findById(id);

        if (adminList.isPresent()){
            return adminList.get();
        }else {
            throw new RuntimeException("employee not found");
        }
    }


    @Override
    public Admin editAdmin(Long id, Admin admin) {
        Admin newAdmin = adminRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException(id+"not found"));

        newAdmin.setAdminTckn(admin.getAdminTckn());
        newAdmin.setAdminName(admin.getAdminName());
        newAdmin.setAdminSurname(admin.getAdminSurname());
        newAdmin.setAdminEmail(admin.getAdminEmail());
        newAdmin.setAdminPassword(admin.getAdminPassword());

        return adminRepository.save(newAdmin);
    }

    @Override
    public Boolean deleteAdmin(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);

        if (admin.isPresent()){
            adminRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("admin not deleted");
    }

    @Override
    public Admin adminLogin(Admin admin) {
        List<Admin> adminList = adminRepository.findAll();

        for (var c : adminList) {
            if (c.getAdminEmail().equals(admin.getAdminEmail()) &&
                    c.getAdminPassword().equals(admin.getAdminPassword())) {
                return c;
            }
        }
        return new Admin(1L, 1L, "", "", "", "");
    }
}
