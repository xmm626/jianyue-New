package com.spring.jianyue.api.controller;

import com.spring.jianyue.api.entity.Follow;
import com.spring.jianyue.api.entity.vo.FollowVO;
import com.spring.jianyue.api.service.FollowService;
import com.spring.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/follow")
public class FollowController {
    @Resource
    private FollowService followService;


    @PostMapping("/add")
    public ResponseResult followUser(@RequestParam("fromUId") int fromUId, @RequestParam("toUId") int toUId) {
        Follow follow = new Follow();
        follow.setFromUId(fromUId);
        follow.setToUId(toUId);
        followService.insertFollow(follow);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancelFollow(@RequestParam("fromUId") int fromUId, @RequestParam("toUId") int toUId) {
        followService.deleteFollow(fromUId, toUId);
        return ResponseResult.success();
    }

    @GetMapping(value = "/list")
    public ResponseResult getFollowsByUId(@RequestParam("fromUId") int fromUId) {
        List<FollowVO> followVOS = followService.getFollowsByUId(fromUId);
        return ResponseResult.success(followVOS);
    }
}
