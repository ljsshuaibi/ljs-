package com.example.demo.Service;
import com.example.demo.entity.Problem;

import java.util.List;
public interface ProblemService {
    public List<Problem> SelectAll();
    public int DisableProblem(Problem problem);
    public int AbleProblem(Problem problem);
    public List<Problem> SelectByUserName(String UserName);
}
