package com.spring.jianyue.api.mapper;


import com.spring.jianyue.api.entity.Like;
import com.spring.jianyue.api.entity.vo.LikeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LikeMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fromlikeUId", column = "fromlike_uid"),
            @Result(property = "tolikeAId", column = "tolike_aid")
    })
    @Select("SELECT * FROM t_like WHERE fromlike_uid = #{fromlikeUId} AND tolike_aid = #{tolikeAId} ")
    Like getLike(@Param("fromlikeUId") int fromlikeUId, @Param("tolikeAId") int tolikeUId);

    @Insert("INSERT INTO t_like (fromlike_uid,tolike_aid) VALUES (#{fromlikeUId},#{tolikeAId}) ")
    void insertLike(Like like);

    @Delete("DELETE  FROM t_like WHERE fromlike_uid = #{fromlikeUId} AND tolike_aid = #{tolikeAId} ")
    void deleteLike(@Param("fromlikeUId") int fromlikeUId, @Param("tolikeAId") int tolikeAId);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fromlikeUId", column = "fromlike_uid"),
            @Result(property = "tolikeAId", column = "tolike_aid"),
            @Result(property = "title", column = "title"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname")
    })
    @Select("SELECT t_like.tolike_aid,t_user.nickname,t_user.avatar,t_article.title FROM t_like,t_user,t_article WHERE t_like.tolike_aid=t_article.id AND t_article.u_id = t_user.id AND t_like.fromlike_uid = #{fromlikeUId} ")
    List<LikeVO> getmyLike(@Param("fromlikeUId") int fromlikeUId);
}
