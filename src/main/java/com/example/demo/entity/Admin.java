package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Admin {
    @NotNull(message = "账号不能为空")
    public String AdminAccount;
    public String AdminPassword;
}
