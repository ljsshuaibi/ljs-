package com.example.demo.Service;

import com.example.demo.entity.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> SelectAll();
    public int AdminLogin(Admin admin);


}
