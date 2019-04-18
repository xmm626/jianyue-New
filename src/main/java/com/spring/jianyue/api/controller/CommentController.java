package com.spring.jianyue.api.controller;

import com.spring.jianyue.api.entity.Comment;
import com.spring.jianyue.api.entity.vo.CommentVO;
import com.spring.jianyue.api.service.CommentService;
import com.spring.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseResult addComment(@RequestParam("aId") int aId, @RequestParam("uId") int uId, @RequestParam("content") String content) {
        Comment comment = new Comment();
        comment.setaId(aId);
        comment.setuId(uId);
        comment.setContent(content);
        comment.setCommentTime(new Date());
        commentService.addComment(comment);
        return ResponseResult.success();
    }

    @GetMapping(value = "/user/{aId}")
    public ResponseResult getrticleByUId(@RequestParam("aId") int aId) {
        List<CommentVO> articleList = commentService.selectCommentsByAId(aId);
        return ResponseResult.success(articleList);
    }
}
