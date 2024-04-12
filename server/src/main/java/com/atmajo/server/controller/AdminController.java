package com.atmajo.server.controller;

import com.atmajo.server.model.Admin;
import com.atmajo.server.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {

    AdminService adminService;

    public AdminController (AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/admin/saveAdmin")
    public ResponseEntity<String> saveAdmin(@RequestBody Admin admin){
        adminService.createAdmin(admin);
        return new ResponseEntity<String>("Admin Saved", HttpStatus.OK);
    }

    @GetMapping("/admin/{adminId}")
    public Admin getAdmin(@PathVariable("adminId") Long adminId, @RequestParam("password") String password){
        return adminService.getAdmin(adminId, password);
    }
}
