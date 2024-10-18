package com.example.demo.Dto;

import com.example.demo.entity.JuBaoProblem;

public class ProblemDto {
    public String JuBaoUserName;
    public String ProblemName;
    public String FaBuUserName;
    public String Reason;
    public int ProblemId;
    public int Status;
    public ProblemDto (JuBaoProblem juBaoProblem,String name,int status) {
        this.JuBaoUserName = juBaoProblem.JuBaoUserName;
        this.ProblemName = name;
        this.ProblemId = juBaoProblem.ProblemId;
        this.FaBuUserName = juBaoProblem.FaBuUserName;
        this.Status = status;
        this.Reason = juBaoProblem.Reason;
    }
}
