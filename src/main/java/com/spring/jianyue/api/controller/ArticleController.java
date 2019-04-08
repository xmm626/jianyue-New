package com.spring.jianyue.api.controller;

import com.aliyun.oss.OSSClient;

import com.spring.jianyue.api.entity.Img;
import com.spring.jianyue.api.entity.vo.ArticleVO;
import com.spring.jianyue.api.entity.vo.CommentVO;
import com.spring.jianyue.api.service.ArticleService;
import com.spring.jianyue.api.service.CommentService;
import com.spring.jianyue.api.service.ImgService;
import com.spring.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @Resource
    private ImgService imgService;

    @GetMapping(value = "/list")
    public ResponseResult getAll() {
        List<ArticleVO> articleList = articleService.selectAll();
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/{aId}")
    public ResponseResult getArticleById(@PathVariable("aId") int aId) {
        ArticleVO article = articleService.getArticleById(aId);
        List<CommentVO> comments = commentService.selectCommentsByAId(aId);
        List<Img> imgs = imgService.selectImgsByAId(aId);

        Map<String, Object> map = new HashMap<>();
        map.put("article", article);
        map.put("comments", comments);
        map.put("imgs", imgs);

        return ResponseResult.success(map);
    }
}
