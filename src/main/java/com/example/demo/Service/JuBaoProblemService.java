package com.example.demo.Service;

import com.example.demo.Dto.ProblemDto;
import com.example.demo.entity.JuBaoHuiDa;
import com.example.demo.entity.JuBaoProblem;

import java.util.List;

public interface JuBaoProblemService {
    public List<ProblemDto> SelectALL();
    public int AddJuBaoProblem(JuBaoProblem juBaoProblem);

    public List<JuBaoProblem> SelectByUserName(String JuBaoUserName);

}
