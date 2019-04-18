package com.spring.jianyue.api.controller;

import com.github.pagehelper.PageHelper;
import com.spring.jianyue.api.entity.Article;
import com.spring.jianyue.api.entity.Follow;
import com.spring.jianyue.api.entity.Like;
import com.spring.jianyue.api.entity.vo.ArticleVO;
import com.spring.jianyue.api.entity.vo.CommentVO;
import com.spring.jianyue.api.service.ArticleService;
import com.spring.jianyue.api.service.CommentService;
import com.spring.jianyue.api.service.FollowService;
import com.spring.jianyue.api.service.LikeService;
import com.spring.jianyue.api.util.MsgConst;
import com.spring.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @Resource
    private FollowService followService;
    @Resource
    private LikeService likeService;

    @GetMapping(value = "/list")
    public ResponseResult getAll() {
        List<ArticleVO> articleList = articleService.selectAll();
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/list1")
    public  ResponseResult getAll1(@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "4") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ArticleVO> articleList = articleService.selectAll();
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/user")
    public ResponseResult getrticleByUId(@RequestParam("userId") int userId) {
        List<ArticleVO> articleList = articleService.getArtcleByUId(userId);
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/{aId}")
    public ResponseResult getArticleById(@PathVariable("aId") int aId,@RequestParam("userId") int userId) {
        ArticleVO article = articleService.getArticleById(aId);
        System.out.println(article);
        int toUId = article.getuId();
        int tolikeAId=article.getId();
        Map<String, Object> map = new HashMap<>();
        Follow follow = followService.getFollow(userId, toUId);
        Like like=likeService.getLike(userId,tolikeAId);
        System.out.println(follow);
        if (follow != null) {
            map.put("followed", MsgConst.FOLLOWED);
        } else {
            map.put("followed", MsgConst.NO_FOLLOWED);
        }
        if (like != null) {
            map.put("likeed", MsgConst.LIKEED);
        } else {
            map.put("likeed", MsgConst.NO_LIKEED);
        }
        List<CommentVO> comments = commentService.selectCommentsByAId(aId);
        map.put("article", article);
        map.put("comments", comments);
        return ResponseResult.success(map);
    }

    @PostMapping("/add")
    public ResponseResult postArticle(@RequestParam("uId") int uId,
                                      @RequestParam("title") String title,
                                      @RequestParam("content") String content) {
        Article article = new Article();
        article.setuId(uId);
        article.setTitle(title);
        article.setContent(content);
        article.setCreateTime(new Date());
        articleService.insertArticle(article);
        //新增文章后，将获取到的自增主键返回给客户端，方便图片地址的写入
        return ResponseResult.success(article.getId());
    }
    @PostMapping("/deleted")
    public ResponseResult deleteArticleByAId(@RequestParam("id") int id,@RequestParam("uId") int uId) {
        articleService.deleteArticleByAId(id,uId);
        return ResponseResult.success();
    }
}
