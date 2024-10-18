package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MoneyMingXi {
    public String MoneyReason;
    public int Money;
    public String UserName;
    public LocalDateTime Time;
}
