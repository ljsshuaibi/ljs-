package com.example.demo.Service.impl;

import com.example.demo.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements com.example.demo.Service.AnswerService{
    @Autowired
    private com.example.demo.Dao.AnswerDao answerDao;
    @Override
    public List<Answer> SelectAll(){
        return answerDao.SelectAllAnswer();
    }
    @Override
    public int DisableAnswer(Answer answer){
        return answerDao.DisableAnswer(answer);
    }
    @Override
    public int AbleAnswer(Answer answer){
        return answerDao.AbleAnswer(answer);
    }
    @Override
    public int EditAnswer(Answer answer){
        return answerDao.EditAnswerGrade(answer);
    }
    @Override
    public int InsertAnswerByUser(Answer answer){
        return answerDao.InsertAnswerByUser(answer);
    }
}
