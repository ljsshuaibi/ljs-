package com.example.demo.controller;

import com.example.demo.Dao.*;
import com.example.demo.Dto.JuBaoHuiDaDto;
import com.example.demo.Dto.JuBaoProblemDto;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.impl.RedisService;
import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class NewController {
    @Autowired
    RedisService redisService;
    @Autowired
    private com.example.demo.Service.UserService userService;
    @Autowired
    private com.example.demo.Service.AdminService adminService;
    @Autowired
    private com.example.demo.Service.TagService tagService;
    @Autowired
    private com.example.demo.Service.ProblemService problemService;
    @Autowired
    private com.example.demo.Service.AnswerService answerService;
    @Autowired
    ProblemDao problemDao;
    @Autowired
    JuBaoAnswerDao juBaoAnswerDao;
    @Autowired
    JuBaoProblemDao juBaoProblemDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AnswerDao answerDao;
    @Autowired
    MoneyDao moneyDao;
    @Autowired
    MingXiDao mingXiDao;
    @Autowired
    TagDao tagDao;
    @Autowired
    private com.example.demo.Service.JuBaoProblemService juBaoProblemService;
    @Autowired
    private com.example.demo.Service.JuBaoHuiDaService juBaoHuiDaService;

    /*在个人界面显示我举报的回答，前端给我一个UserName，返回一个List<JuBaoHuiDaDto>*/
    @PostMapping("/JuBaoHuiDaDto/{UserName}")
    public List<JuBaoHuiDaDto> SelectJuBaoHuiDa(@PathVariable String UserName) {
        List<JuBaoHuiDa> juBaoHuiDaList = juBaoHuiDaService.SelectByUserName(UserName);
        if (juBaoHuiDaList == null) {
            return null;
        }
        List<JuBaoHuiDaDto> juBaoHuiDaDtoList = new ArrayList<>();
        for (JuBaoHuiDa juBaoHuiDa : juBaoHuiDaList) {
            Answer answer = answerDao.SelectById(juBaoHuiDa.getAnswerId());
            if (answer.getStatus() == 1) {
                juBaoHuiDaDtoList.add(new JuBaoHuiDaDto(juBaoHuiDa, 1));
            } else {
                juBaoHuiDaDtoList.add(new JuBaoHuiDaDto(juBaoHuiDa, 0));
            }
        }
        return juBaoHuiDaDtoList;
    }

    @PostMapping("/JuBaoProblemDto/{UserName}")
    public List<JuBaoProblemDto> SelectJuBaoProblem(@PathVariable String UserName) {
        List<JuBaoProblem> juBaoProblemList = juBaoProblemService.SelectByUserName(UserName);
        if (juBaoProblemList == null) {
            return null;
        }
        List<JuBaoProblemDto> juBaoProblemDtoList = new ArrayList<>();
        for (JuBaoProblem juBaoProblem : juBaoProblemList) {
            Problem problem = problemDao.SelectById(juBaoProblem.getProblemId());
            if (problem.getStatus() == 0) {
                juBaoProblemDtoList.add(new JuBaoProblemDto(juBaoProblem, 0));
            } else {
                juBaoProblemDtoList.add(new JuBaoProblemDto(juBaoProblem, 1));
            }
        }
        return juBaoProblemDtoList;
    }

    @PostMapping("/Last/{UserName}")
    public List<MoneyMingXi> SelectLast(@PathVariable String UserName) {
        return mingXiDao.SelectByUserName(UserName);
    }

    @PostMapping("/User/DeleteProblem/{ProblemId}")
    public int DeleteProblem(@PathVariable int ProblemId) {
        List<Answer> answers=answerDao.SelectByProblemId(ProblemId);
        for (Answer answer:answers){
            juBaoAnswerDao.DeleteJuBaoHuiDa(Integer.parseInt(answer.getId()));
        }
        answerDao.DeleteAnswer(ProblemId);
        juBaoProblemDao.DeleteJuBaoProblem(ProblemId);
        return problemDao.DeleteProblem(ProblemId);
    }

    @PostMapping("/User/DeleteAnswer/{AnswerId}")
    public int DeleteAnswer(@PathVariable int AnswerId) {

        if (answerDao.DeleteAnswer(AnswerId) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @PostMapping("/testredis")
    public String testredis() {
        return redisService.get("age");
    }

    /*用户收藏问题*/
    @PostMapping("/User/AddProblem/{ProblemId}/{UserName}")
    public int AddProblem(@PathVariable int ProblemId, @PathVariable String UserName) {
        /*检测用户是否初始化*/
        if (redisService.get(UserName) != null) {
            String ljs = redisService.get(UserName) + " " + ProblemId;
            redisService.set(UserName, ljs);
        } else {
            redisService.set(UserName, Integer.toString(ProblemId));
        }
        return 1;
    }

    /*展示该用户所收藏的问题*/
    @PostMapping("/User/SelectProblem/{UserName}")
    public List<Problem> SelectProblem(@PathVariable String UserName) {
        if (redisService.get(UserName) == null) return null;
        String[] split = redisService.get(UserName).split(" ");
        List<Problem> problemList = new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()) {
                problemList.add(problemDao.SelectById(Integer.parseInt(s)));
            }
        }
        return problemList;
    }

    /*取消收藏*/
    @PostMapping("/User/DeletLikeProblem/{ProblemId}/{UserName}")
    public int DeletLikeProblem(@PathVariable int ProblemId, @PathVariable String UserName) {
        String ljs = redisService.get(UserName);
        String[] split = ljs.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        list.remove(Integer.toString(ProblemId));
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + " ");
        }
        redisService.set(UserName, sb.toString());
        return 1;
    }

    /*界面展示今日登陆人数总数 管理界面与用户界面公用该接口*/
    @PostMapping("/TodayLogin")
    public int TodayLogin() {
        return Integer.parseInt(redisService.get("TotalPerson"));
    }

    /*平台总问题数*/
    @PostMapping("/TotalProblem")
    public int TotalProblem() {
        return problemDao.SelectAll().size();
    }

    /*平台总用户数*/
    @PostMapping("/TotalUser")
    public int TotalUser() {
        return userDao.SelectAll().size();
    }

    /*平台总回答数*/
    @PostMapping("/TotalAnswer")
    public int TotalAnswer() {
        return answerDao.SelectAllAnswer().size();
    }

    /*平台今日新发布的问题数*/
    @PostMapping("/NewProblem")
    public int NewProblem() {
        return Integer.parseInt(redisService.get("TotalProblem"));
    }

    /*平台今日新发布的回答数*/
    @PostMapping("/NewAnswer")
    public int NewAnswer() {
        return Integer.parseInt(redisService.get("TotalAnswer"));
    }

    /*平台总用户数*/
    @PostMapping("/NewLogin")
    public int NewLogin() {
        return userDao.SelectAll().size();
    }

    /*问题展示该问题下的回答数量,前台给我一个ProblemId*/
    @PostMapping("/User/CountAnswer/{ProblemId}")
    public int CountAnswer(@PathVariable int ProblemId) {
        return answerDao.SelectByProblemId(ProblemId).size();
    }
}

