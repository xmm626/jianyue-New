package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.Follow;
import com.spring.jianyue.api.entity.vo.FollowVO;
import com.spring.jianyue.api.service.FollowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceImplTest {
    @Autowired
    private FollowService followService;
    @Test
    public void getFollow() {
        Follow follow=followService.getFollow(1,5);
        System.out.println(follow);
    }

    @Test
    public void getFollowsByUId() {
        List<FollowVO> followVOS=followService.getFollowsByUId(1);
        System.out.println(followVOS);
    }

    @Test
    public void insertFollow() {
        Follow follow=new Follow();
        follow.setFromUId(1);
        follow.setToUId(6);
        followService.insertFollow(follow);
    }

    @Test
    public void deleteFollow() {
        followService.deleteFollow(1,6);
    }
}