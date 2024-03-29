package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.Article;
import com.spring.jianyue.api.entity.Img;
import com.spring.jianyue.api.entity.vo.ArticleVO;
import com.spring.jianyue.api.mapper.ArticleMapper;
import com.spring.jianyue.api.mapper.CommentMapper;
import com.spring.jianyue.api.mapper.ImgMapper;
import com.spring.jianyue.api.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ImgMapper imgMapper;
    @Resource
    private CommentMapper commentMapper;
    @Override
    public List<ArticleVO> selectAll() {
        List<ArticleVO> articles=articleMapper.selectAll();
        for (ArticleVO articleVO:articles){
            articleVO.setImgs(imgMapper.selectImgsByAId(articleVO.getId()));
            articleVO.setComments(commentMapper.selectCommentsByAId(articleVO.getId()).size());
        }
        return articles;
    }

    @Override
    public ArticleVO getArticleById(int aId) {
        return articleMapper.getArticleById(aId);
    }

    @Override
    public List<ArticleVO> getArtcleByUId(int uId) {
        List<ArticleVO> articles=articleMapper.getArticleByUId(uId);
        for (ArticleVO articleVO:articles){
            articleVO.setImgs(imgMapper.selectImgsByAId(articleVO.getId()));
        }
        return articles;
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public void deleteArticleByAId(int id,int uId) {
        articleMapper.deleteArticleByAId(id,uId);
    }


}
