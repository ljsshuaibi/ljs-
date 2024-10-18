package com.example.demo.Dao;

import com.example.demo.entity.JuBaoHuiDa;
import com.example.demo.entity.JuBaoProblem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JuBaoAnswerDao {
    @Select("SELECT * from jubaohuida")
    public List<JuBaoHuiDa> SelectAll();
    @Insert("INSERT INTO jubaohuida(AnswerId,Reason,JuBaoUserName,FaBuUserName) VALUES(#{AnswerId},#{Reason},#{JuBaoUserName},#{FaBuUserName})")
    public int InsertJuBaoHuiDa(JuBaoHuiDa juBaoHuiDa);
    @Select("Select * from jubaohuida where JuBaoUserName=#{JuBaoUserName}")
    public List<JuBaoHuiDa> SelectByUserName(String JuBaoUserName);
    @Delete("DELETE FROM jubaohuida WHERE AnswerId=#{AnswerId}")
    public int DeleteJuBaoHuiDa( int AnswerId);

}
