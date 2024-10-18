package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Problem {
    public String ProblemName;
    public String Tag;
    public int Money;
    public int Id;
    public String UserName;
    public int Status;
    public LocalDateTime Time;
}
