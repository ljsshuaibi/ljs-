package com.example.demo.Dao;

import com.example.demo.entity.JuBaoHuiDa;
import com.example.demo.entity.JuBaoProblem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface JuBaoProblemDao {
    @Select("SELECT * from jubaoproblem")
    public List<JuBaoProblem> SelectAll();
    @Insert("INSERT INTO jubaoproblem(ProblemId,Reason,JuBaoUserName,FaBuUserName) VALUES(#{ProblemId},#{Reason},#{JuBaoUserName},#{FaBuUserName})")
    public int InsertJuBaoProblem(JuBaoProblem juBaoProblem);

    @Select("Select * from jubaoproblem where JuBaoUserName=#{JuBaoUserName}")
    public List<JuBaoProblem> SelectByUserName(String JuBaoUserName);
    @Delete("DELETE FROM jubaoproblem WHERE ProblemId=#{ProblemId}")
    public int DeleteJuBaoProblem( int ProblemId);
}
