package com.example.demo.Service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> SelectAll();
    public User SelectByName(String Name);

    public int DisableUser(String UserName);

    public int AbleUser(String UserName);

    public User UserLogin(User user);
}
