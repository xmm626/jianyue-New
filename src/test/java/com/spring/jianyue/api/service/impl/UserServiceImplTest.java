package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.User;
import com.spring.jianyue.api.entity.dto.UserDTO;
import com.spring.jianyue.api.service.UserService;
import com.spring.jianyue.api.util.StatusConst;
import com.spring.jianyue.api.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void getUserByMobile() {
        User user = userService.getUserByMobile("13844444444");
        System.out.println(user);
    }

    @Test
    public void signIn() {
        UserDTO loginUser = new UserDTO();
        loginUser.setMobile("13866296378");
        String base64Pass = StringUtil.getBase64Encoder("111");
        loginUser.setPassword(base64Pass);
        int status = userService.signIn(loginUser);
        Assert.assertEquals(StatusConst.SUCCESS, status);
    }
    @Test
    public void updateUser(){
        User user=userService.getUserById(1);
        user.setAvatar("999.jpg");
        userService.updateUser(user);
    }
}