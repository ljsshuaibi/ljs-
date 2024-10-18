package com.example.demo.Dao;

import com.example.demo.entity.Answer;
import com.example.demo.entity.FatherAnswer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnswerDao {
    @Select("select * from answer")
    public List<Answer> SelectAllAnswer();
    @Update("update answer set Status=0 where Id=#{Id}")
    public int DisableAnswer(Answer answer);
    @Update("update answer set Status=1 where Id=#{Id}")
    public int AbleAnswer(Answer answer);
    @Select("SELECT * from answer where Id=#{Id}")
    public Answer SelectById(int Id);
    @Select("SELECT * from answer where ProblemId=#{ProblemId} and FatherAnswerId=0")
    public List<Answer> SelectByProblemId(int ProblemId);
    @Insert("INSERT INTO answer(UserName,ProblemId,Status,AnswerName,Time,Gradle) VALUES(#{UserName},#{ProblemId},#{Status},#{AnswerName},#{Time},#{Gradle})")
    public int InsertAnswer(Answer answer);
    @Select("SELECT * from answer where UserName=#{UserName}")
    public List<Answer> SelectByUserName(String UserName);
    @Update("UPDATE answer set Gradle=#{Gradle} where Id=#{Id} ")
    public int EditAnswerGrade(Answer answer);
    @Insert("INSERT INTO answer(UserName,ProblemId,Status,AnswerName,Time,Gradle,FatherAnswerId) VALUES(#{UserName},#{ProblemId},#{Status},#{AnswerName},#{Time},#{Gradle},#{FatherAnswerId})")
    public int InsertAnswerByUser(Answer answer);
    @Select("SELECT * from answer where ProblemId=#{Id} ")
    public List<Answer> SelectMaxGrade(int Id);
    @Delete("delete from answer where Id=#{Id}")
    public int DeleteAnswer(int Id);
    @Insert("INSERT INTO answer(UserName,ProblemId,Status,AnswerName,Time,Gradle,FatherAnswerId) VALUES(#{UserName},#{ProblemId},#{Status},#{AnswerName},#{Time},#{Gradle},#{FatherAnswerId})")
    public int InsertFatherAnswer(FatherAnswer fatherAnswer);
    @Select("SELECT * from answer where FatherAnswerId=#{Id} ")
    public List<Answer> SelectChildrenAnswer(int Id);
}
