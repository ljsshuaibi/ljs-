package com.example.demo.Service.impl;

import com.example.demo.Dao.AnswerDao;
import com.example.demo.Dao.ProblemDao;
import com.example.demo.Dto.AnswerDto;
import com.example.demo.Service.JuBaoHuiDaService;
import com.example.demo.entity.Answer;
import com.example.demo.entity.JuBaoHuiDa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JuBaoHuiDaServiceImpl implements JuBaoHuiDaService {
    @Autowired
    private com.example.demo.Dao.JuBaoAnswerDao juBaoHuiDaDao;
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private AnswerDao answerDao;
    @Override
    public List<AnswerDto> SelectALL() {

        List<JuBaoHuiDa> juBaoHuiDaList=juBaoHuiDaDao.SelectAll();
        List<AnswerDto> answerDtoList=new ArrayList<>();
        for(JuBaoHuiDa juBaoHuiDa:juBaoHuiDaList)
        {
            Answer answer=answerDao.SelectById(juBaoHuiDa.getAnswerId());
            answerDtoList.add(new AnswerDto(juBaoHuiDa,problemDao.SelectById(answer.getProblemId()),answerDao.SelectById(juBaoHuiDa.getAnswerId())));
        }
        return answerDtoList;
    }
    @Override
    public int AddJuBaoHuiDa(JuBaoHuiDa juBaoHuiDa){
        return juBaoHuiDaDao.InsertJuBaoHuiDa(juBaoHuiDa);
    }
    @Override
    public List<JuBaoHuiDa> SelectByUserName(String UserName){
        return juBaoHuiDaDao.SelectByUserName(UserName);
    }
}
