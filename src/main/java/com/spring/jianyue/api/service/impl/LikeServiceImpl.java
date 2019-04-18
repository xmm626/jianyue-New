package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.Like;
import com.spring.jianyue.api.entity.vo.LikeVO;
import com.spring.jianyue.api.mapper.LikeMapper;
import com.spring.jianyue.api.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeMapper likeMapper;

    @Override
    public Like getLike(int fromlikeUId, int tolikeAId) {
        return likeMapper.getLike(fromlikeUId,tolikeAId);
    }

    @Override
    public void insertLike(Like like) {
        likeMapper.insertLike(like);
    }

    @Override
    public void deleteLike(int fromlikeUId, int tolikeAId) {
        likeMapper.deleteLike(fromlikeUId,tolikeAId);
    }

    @Override
    public List<LikeVO> getmyLike(int fromlikeUId) {
        return likeMapper.getmyLike(fromlikeUId);
    }
}
