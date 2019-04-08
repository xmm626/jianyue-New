package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.Article;
import com.spring.jianyue.api.entity.vo.ArticleVO;
import com.spring.jianyue.api.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;
    @Test
    public void selectAll() {
        List<ArticleVO> article= articleService.selectAll();
        System.out.println(article);
    }

    @Test
    public void getArticleById() {
        ArticleVO articleVO=articleService.getArticleById(1);
        System.out.println(articleVO);


    }
}