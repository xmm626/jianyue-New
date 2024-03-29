package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.Comment;
import com.spring.jianyue.api.entity.vo.CommentVO;
import com.spring.jianyue.api.mapper.CommentMapper;
import com.spring.jianyue.api.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<CommentVO> selectCommentsByAId(int aId) {
        return commentMapper.selectCommentsByAId(aId);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> selectCommentsCountByAId(int aId) {
        return commentMapper.selectCommentsCountByAId(aId);
    }
}
