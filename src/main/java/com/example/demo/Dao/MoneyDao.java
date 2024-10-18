package com.example.demo.Dao;

import com.example.demo.entity.Money;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MoneyDao {
    @Select("select * from money where UserName=#{UserName}")
    public Money SelectByUserName(String UserName);
    @Update("update money set Money=#{Money} where UserName=#{UserName}")
    public int AddMoney(Money money);
    @Update("update money set Money=#{Money} where UserName=#{UserName}")
    public int SubMoney(Money money);
    @Insert("INSERT INTO money (UserName,Money) values (#{UserName},#{Money})")
    public int InsertMoney(Money money);
}
