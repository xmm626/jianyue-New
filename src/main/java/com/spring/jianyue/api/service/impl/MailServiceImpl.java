package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("2416890600@qq.com");//发起者
        mailMessage.setTo("915290060@qq.com");//接受者
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            mailSender.send(mailMessage);
            System.out.println("发送简单邮件");
        }catch (Exception e){
            System.out.println("发送简单邮件失败");
        }
    }
}
