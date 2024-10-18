package com.example.demo.Dao;

import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminDao {
    @Select("select * from admin")
    public List<Admin> SelectAll();
    @Select("select * from admin where AdminAccount=#{AdminAccount} and AdminPassword=#{AdminPassword}")
    public Admin SelectByAccount(Admin admin);

}
