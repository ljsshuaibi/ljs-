package com.example.demo.Service;

import com.example.demo.entity.Answer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AnswerService {
    public List<Answer> SelectAll();
    public int DisableAnswer(Answer answer);
    public int AbleAnswer(Answer answer);
    public int EditAnswer(Answer answer);
    public int InsertAnswerByUser(Answer answer);
}
