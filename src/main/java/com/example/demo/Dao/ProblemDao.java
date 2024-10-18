package com.example.demo.Dao;

import com.example.demo.entity.Problem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProblemDao {
    @Select("select * from proplem")
    public List<Problem> SelectAll();
    @Update("update proplem set Status=0 where Id=#{Id}")
    public int DisableProblem(Problem problem);
    @Update("update proplem set Status=1 where Id=#{Id}")
    public int AbleProblem(Problem problem);
    @Select("SELECT * from proplem where Id=#{Id}")
    public Problem SelectById(int Id);
    @Select("SELECT * from proplem where ProblemName like CONCAT('%', #{name}, '%')")
    public List<Problem> SelectByName(String Name);
    @Select("SELECT * from proplem where UserName=#{UserName}")
    public List<Problem> SelectByUserName(String UserName);
    @Insert("INSERT INTO proplem(ProblemName,Tag,Money,UserName,Status,Time) VALUES(#{ProblemName},#{Tag},#{Money},#{UserName},#{Status},#{Time})")
    public int InsertProblem(Problem problem);
    @Update("update proplem set Status=2 where Id=#{Id}")
    public int EditMoneyStatus(int Id);
    @Select("SELECT * from proplem where Tag=#{Tag}")
    public List<Problem> SelectProblemByTag(String Tag);
    @Delete("delete from proplem where Id=#{Id}")
    public int DeleteProblem(int Id);

}
