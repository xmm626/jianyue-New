package com.spring.jianyue.api.service;

import com.spring.jianyue.api.entity.vo.CommentVO;

import java.util.List;

public interface CommentService {
    List<CommentVO> selectCommentsByAId(int aId);
}
