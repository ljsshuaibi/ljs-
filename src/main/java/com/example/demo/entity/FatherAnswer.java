package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FatherAnswer {
    public String Id;
    public String UserName;
    public int ProblemId;
    public int Status;
    public int Gradle;
    public String AnswerName;
    public LocalDateTime Time;
    public int FatherAnswerId;
    public FatherAnswer(Answer answer){
        this.Id=answer.getId();
        this.UserName=answer.getUserName();
        this.ProblemId=answer.getProblemId();
        this.Status=answer.getStatus();
        this.Gradle=answer.getGradle();
        this.AnswerName=answer.getAnswerName();
        this.Time=answer.getTime();
    }
}
