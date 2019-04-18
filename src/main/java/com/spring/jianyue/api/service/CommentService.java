package com.spring.jianyue.api.service;

import com.spring.jianyue.api.entity.Comment;
import com.spring.jianyue.api.entity.vo.CommentVO;

import java.util.List;

public interface CommentService {
    List<CommentVO> selectCommentsByAId(int aId);

    void addComment(Comment comment);

    List<Comment> selectCommentsCountByAId(int aId);
}
