package com.example.demo.Dto;

import com.example.demo.entity.Answer;
import com.example.demo.entity.JuBaoHuiDa;
import com.example.demo.entity.Problem;

public class AnswerDto {
    public String JuBaoUserName;
    public int AnswerId;
    public String FaBuUserName;
    public String Reason;
    public String ProblemName;
    public int ProblemId;
    public String AnswerName;
    public int Status;
    public AnswerDto(JuBaoHuiDa juBaoAnswer, Problem problem, Answer answer)
    {
        this.JuBaoUserName = juBaoAnswer.JuBaoUserName;
        this.AnswerId = juBaoAnswer.AnswerId;
        this.FaBuUserName = juBaoAnswer.FaBuUserName;
        this.Reason = juBaoAnswer.Reason;
        this.ProblemName = problem.getProblemName();
        this.ProblemId = problem.getId();
        this.Status = answer.getStatus();
        this.AnswerName = answer.getAnswerName();
    }
}
