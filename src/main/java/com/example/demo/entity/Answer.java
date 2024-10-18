package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Answer {
    public String Id;
    public String UserName;
    public int ProblemId;
    public int Status;
    public int Gradle;
    public String AnswerName;
    public LocalDateTime Time;
    public int FatherAnswerId;
}
