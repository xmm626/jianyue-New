package com.spring.jianyue.api.mapper;

import com.spring.jianyue.api.entity.Img;
import com.spring.jianyue.api.entity.vo.ArticleVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select("SELECT t_article.*,t_user.`nickname`,t_user.`avatar` " +
            "FROM t_article LEFT JOIN t_user ON t_article.u_id = t_user.id")
    List<ArticleVO> selectAll();


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select(" SELECT t_article.*,t_user.nickname,t_user.avatar " +
            " FROM t_article LEFT JOIN t_user ON t_article.u_id = t_user.id " +
            " WHERE t_article.id = #{id} ")
    ArticleVO getArticleById(int aId);


}
