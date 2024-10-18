package com.example.demo.Schedule;

import com.example.demo.Service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EveryDay {
    @Autowired
    RedisService redisService;
    /*每天凌晨0点刷新登录数据为0*/
    @Scheduled(cron = "0 0 0 * * ?")
    public void fixedRate() {
        redisService.set("TodayProblem", String.valueOf(0));
        redisService.set("TodayAnswer", String.valueOf(0));
        redisService.set("TotalPerson", String.valueOf(0));
    }
}
