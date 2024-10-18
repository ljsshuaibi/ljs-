package com.example.demo.Service;

import com.example.demo.Dto.AnswerDto;
import com.example.demo.entity.JuBaoHuiDa;

import java.util.List;

public interface JuBaoHuiDaService {
    public List<AnswerDto> SelectALL();
    public int AddJuBaoHuiDa(JuBaoHuiDa juBaoHuiDa);
    public List<JuBaoHuiDa> SelectByUserName(String UserName);
}
