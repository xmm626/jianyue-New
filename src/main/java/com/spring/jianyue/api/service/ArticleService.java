package com.spring.jianyue.api.service;

import com.spring.jianyue.api.entity.Img;
import com.spring.jianyue.api.entity.vo.ArticleVO;

import java.util.List;

public interface ArticleService {

    List<ArticleVO> selectAll();


    ArticleVO getArticleById(int aId);


}
