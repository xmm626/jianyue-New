package com.spring.jianyue.api.service;

import com.spring.jianyue.api.entity.Like;
import com.spring.jianyue.api.entity.vo.LikeVO;

import java.util.List;

public interface LikeService {

    Like getLike(int fromlikeUId, int tolikeAId);

    void insertLike(Like like);

    void deleteLike(int fromlikeUId,int tolikeAId);

    List<LikeVO> getmyLike(int fromlikeUId);
}
