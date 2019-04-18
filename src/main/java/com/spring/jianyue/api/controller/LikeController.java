package com.spring.jianyue.api.controller;

import com.spring.jianyue.api.entity.Like;
import com.spring.jianyue.api.entity.vo.LikeVO;
import com.spring.jianyue.api.service.LikeService;
import com.spring.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/like")
public class LikeController {
    @Resource
    private LikeService likeService;

    @PostMapping("/add")
    public ResponseResult likeUser(@RequestParam("fromlikeUId") int fromlikeUId, @RequestParam("tolikeAId") int tolikeAId) {
        Like like = new Like();
        like.setFromlikeUId(fromlikeUId);
        like.setTolikeAId(tolikeAId);
        likeService.insertLike(like);
        return ResponseResult.success();
    }

    @PostMapping("/cancel")
    public ResponseResult cancellike(@RequestParam("fromlikeUId") int fromlikeUId, @RequestParam("tolikeAId") int tolikeAId) {
        likeService.deleteLike(fromlikeUId, tolikeAId);
        return ResponseResult.success();
    }
    @GetMapping(value = "/list")
    public ResponseResult getlikeByUId(@RequestParam("fromlikeUId") int fromlikeUId) {
        List<LikeVO> likeVOS = likeService.getmyLike(fromlikeUId);
        return ResponseResult.success(likeVOS);
    }
}
