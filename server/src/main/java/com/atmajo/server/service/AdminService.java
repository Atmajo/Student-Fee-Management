package com.atmajo.server.service;

import com.atmajo.server.model.Admin;

import java.util.List;

public interface AdminService {
    public void createAdmin(Admin user);
    public void updateAdmin(Long adminId);
    public void deleteAdmin(Long adminId);
    public Admin getAdmin(Long adminId, String password);
}
