package com.spring.jianyue.api.service;

import com.spring.jianyue.api.entity.Img;

import java.util.List;

public interface ImgService {
    List<Img> selectImgsByAId(int aId);

}
