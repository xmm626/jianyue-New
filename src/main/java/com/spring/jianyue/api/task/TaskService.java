package com.spring.jianyue.api.task;

import com.spring.jianyue.api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
//@Async
public class TaskService {
    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 31 9 ? * *")
   //@Scheduled(cron = "*/3 * * * *  ?")
    public void proces(){
        mailService.sendMail("915290060@qq.com","濛哥发的","嘤嘤嘤");
        System.out.println("111");
    }
}
