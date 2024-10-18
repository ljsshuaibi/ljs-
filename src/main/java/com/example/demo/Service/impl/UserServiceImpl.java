package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private com.example.demo.Dao.UserDao UserDao;
    @Override
    public List<User> SelectAll(){
        return UserDao.SelectAll();
    }
    @Override
    public User SelectByName(String Name){
        return UserDao.SelectByName(Name);
    }
    @Override
    public int DisableUser(String UserName){
        return UserDao.DisableUser(UserName);
    }
    @Override
    public int AbleUser(String UserName){
        return UserDao.AbleUser(UserName);
    }
    @Override
    public User UserLogin(User user){
        return UserDao.Login(user);
    }
}
