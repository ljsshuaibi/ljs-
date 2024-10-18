package com.example.demo.Dao;

import com.example.demo.entity.MoneyMingXi;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MingXiDao {
    @Select("select * from mingxi where UserName=#{UserName} ORDER BY Time DESC")
    public List<MoneyMingXi> SelectByUserName(String UserName);
    @Insert("insert into mingxi(MoneyReason,Money,UserName,Time) values(#{MoneyReason},#{Money},#{UserName},#{Time})")
    public int InsertMoneyMingXi(MoneyMingXi moneyMingXi);
}
