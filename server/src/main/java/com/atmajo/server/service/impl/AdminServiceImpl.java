package com.atmajo.server.service.impl;

import com.atmajo.server.model.Admin;
import com.atmajo.server.repository.AdminRepo;
import com.atmajo.server.service.AdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService  {

    AdminRepo adminRepo;

    public AdminServiceImpl(AdminRepo adminRepo){
        this.adminRepo = adminRepo;
    }

    @Override
    public void createAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    @Override
    public void updateAdmin(Long adminId) {
        Optional<Admin> optionalAdmin = adminRepo.findById(adminId);
        if(optionalAdmin.isPresent()){
            Admin admin = optionalAdmin.get();
            adminRepo.save(admin);
        }
        else {
            throw new RuntimeException("Admin not found");
        }
    }

    @Override
    public void deleteAdmin(Long adminId) {
        adminRepo.deleteById(adminId);
    }

    @Override
    public Admin getAdmin(Long adminId, String password) {
        Optional<Admin> optionalAdmin = adminRepo.findById(adminId);
        if (!optionalAdmin.isPresent()){
            throw new RuntimeException("Admin not found");
        }
        Admin admin = optionalAdmin.get();
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
        if (!decoder.matches(password, admin.getPassword())){
            throw new RuntimeException("Incorrect password");
        }
        return admin;
    }
}
