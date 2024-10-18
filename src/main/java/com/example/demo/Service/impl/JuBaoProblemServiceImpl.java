package com.example.demo.Service.impl;

import com.example.demo.Dao.JuBaoProblemDao;
import com.example.demo.Dao.ProblemDao;
import com.example.demo.Dto.ProblemDto;
import com.example.demo.Service.JuBaoProblemService;
import com.example.demo.entity.JuBaoHuiDa;
import com.example.demo.entity.JuBaoProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuBaoProblemServiceImpl implements JuBaoProblemService {
    @Autowired
    JuBaoProblemDao juBaoProblemDao;
    @Autowired
    ProblemDao problemDao;
    @Override
    public List<ProblemDto> SelectALL(){
        List<JuBaoProblem> juBaoProblemList= juBaoProblemDao.SelectAll();
        List<ProblemDto> problemDtoList=new java.util.ArrayList<>();
        for(JuBaoProblem juBaoProblem:juBaoProblemList){
            String name=problemDao.SelectById(juBaoProblem.getProblemId()).getProblemName();
            int Status=problemDao.SelectById(juBaoProblem.getProblemId()).getStatus();
            problemDtoList.add(new ProblemDto(juBaoProblem,name,Status));
        }
        return problemDtoList;
    }
    @Override
    public int AddJuBaoProblem(JuBaoProblem juBaoProblem){
        return juBaoProblemDao.InsertJuBaoProblem(juBaoProblem);
    }
    @Override
    public List<JuBaoProblem> SelectByUserName(String JuBaoUserName){
        return juBaoProblemDao.SelectByUserName(JuBaoUserName);
    }
}
