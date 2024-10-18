package com.example.demo.Dao;

import com.example.demo.entity.Money;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    public List<User> SelectAll();
    @Select("select * from user where UserName=#{UserName}")
    public User SelectByName(String UserName);
    @Update("update user set Status=0 where UserName=#{UserName}")
    public int DisableUser(String UserName);
    @Update("update user set Status=1 where UserName=#{UserName}")
    public int AbleUser(String UserName);

    @Select("select * from user where UserName=#{UserName} and UserPassword=#{UserPassword}")
    public User Login(User user);
    @Update("update money  set Money = #{Money} where UserName=#{UserName}")
    public int  AddMoney(Money money);
    @Update("update money  set Money = #{Money} where UserName=#{UserName}")
    public int  SubMoney(Money money);
    @Insert("insert into user (UserName,UserAccount,UserPassword,UserPhoneNumber,UserSex,Status)  VALUES (#{userName}, #{userAccount}, #{userPassword}, #{userPhoneNumber}, #{userSex},#{Status})")
    public int InsertUser(User user);
    @Update("UPDATE user SET UserName=#{UserName},UserPassword=#{UserPassword},UserSex=#{UserSex},UserPhoneNumber=#{UserPhoneNumber} where Useraccount=#{UserAccount} ")
    public int XiuGai(User user);
}
