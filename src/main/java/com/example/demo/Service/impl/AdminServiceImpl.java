package com.example.demo.Service.impl;

import com.example.demo.Dao.AdminDao;
import com.example.demo.Service.AdminService;
import com.example.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    @Override
    public List<Admin> SelectAll()
    {
        return adminDao.SelectAll();
    }
    @Override
    public int AdminLogin(Admin admin){
        Admin admin1=adminDao.SelectByAccount(admin);
        if(admin1!=null){
            return 1;
        }else {
            return 0;
        }
    }
}
