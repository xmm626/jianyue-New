package com.spring.jianyue.api.service;

import com.spring.jianyue.api.entity.Follow;
import com.spring.jianyue.api.entity.vo.FollowVO;

import java.util.List;

public interface FollowService {
    Follow getFollow(int fromUId,int toUID);

    List<FollowVO> getFollowsByUId(int fromUId);

    void insertFollow(Follow follow);

    void deleteFollow(int fromUId, int toUId);
}
