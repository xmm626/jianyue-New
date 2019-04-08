package com.spring.jianyue.api.mapper;

import com.spring.jianyue.api.entity.vo.CommentVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uId", column = "u_id"),
            @Result(property = "aId", column = "a_id"),
            @Result(property = "content", column = "content"),
            @Result(property = "commentTime", column = "comment_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar"),
    })
    @Select("SELECT t_comment.*,t_user.nickname,t_user.avatar FROM t_user,t_comment WHERE t_comment.u_id=t_user.id AND t_comment.a_id=#{aId} ")
    List<CommentVO> selectCommentsByAId(int aId);
}
