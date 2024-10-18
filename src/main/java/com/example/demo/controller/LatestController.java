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
public class LatestController {
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
    /*用户回答回答*/
    @PostMapping("/UserAAnswer/{AnswerId}")
    public int AAnswer(@RequestBody Answer answer,@PathVariable int AnswerId){
        redisService.set("TotalAnswer",Integer.toString(Integer.parseInt(redisService.get("TotalAnswer"))+1));
        answer.setStatus(1);
        answer.setTime(LocalDateTime.now());
        FatherAnswer fatherAnswer=new FatherAnswer(answer);
        fatherAnswer.setFatherAnswerId(AnswerId);
        return answerDao.InsertFatherAnswer(fatherAnswer);
    }
    /*展示子回答*/
    @PostMapping("/ChildrenAnswer/{FatherAnswerId}")
    public List<Answer> ChildrenAnswer(@PathVariable int FatherAnswerId){
        return answerDao.SelectChildrenAnswer(FatherAnswerId);
    }
}
