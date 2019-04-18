package com.spring.jianyue.api.mapper;

import com.spring.jianyue.api.entity.Article;
import com.spring.jianyue.api.entity.Img;
import com.spring.jianyue.api.entity.vo.ArticleVO;
import org.apache.ibatis.annotations.*;

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
            " WHERE t_article.id = #{id} order by create_time asc")
    ArticleVO getArticleById(int aId);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Insert("INSERT INTO t_article (u_id,title,content,create_time) VALUES (#{uId},#{title},#{content},#{createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertArticle(Article article);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Select(" SELECT * FROM t_article WHERE u_id=#{uId}")
    List<ArticleVO> getArticleByUId(int uId);


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    @Delete("DELETE  FROM t_article WHERE id = #{id} AND u_id = #{uId}")
    void deleteArticleByAId(@Param("id") int id,@Param("uId") int uId);


}
