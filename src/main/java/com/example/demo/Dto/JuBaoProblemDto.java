package com.example.demo.Dto;

import com.example.demo.entity.JuBaoProblem;
import lombok.Data;

@Data
public class JuBaoProblemDto {
    public String JuBaoUserName;
    public int ProblemId;
    public String FaBuUserName;
    public String Reason;
    public int Status;
    public JuBaoProblemDto(JuBaoProblem juBaoProblem,int status){
        this.JuBaoUserName=juBaoProblem.getJuBaoUserName();
        this.ProblemId=juBaoProblem.getProblemId();
        this.FaBuUserName=juBaoProblem.getFaBuUserName();
        this.Reason=juBaoProblem.getReason();
        this.Status=status;
    }
}
