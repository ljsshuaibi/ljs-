package com.example.demo.Service.impl;

import com.example.demo.Service.ProblemService;
import com.example.demo.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private com.example.demo.Dao.ProblemDao ProblemDao;
    @Override
    public List<Problem> SelectAll() {
        return ProblemDao.SelectAll();
    }
    @Override
    public int DisableProblem(Problem problem) {
        return ProblemDao.DisableProblem(problem);
    }
    @Override
    public int AbleProblem(Problem problem) {
        return ProblemDao.AbleProblem(problem);
    }
    @Override
    public List<Problem> SelectByUserName(String UserName){
        return ProblemDao.SelectByUserName(UserName);
    }
}
