package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.Img;
import com.spring.jianyue.api.mapper.ImgMapper;
import com.spring.jianyue.api.service.ImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ImgServiceImpl implements ImgService {
    @Resource
    private ImgMapper imgMapper;
    @Override
    public List<Img> selectImgsByAId(int aId) {
        return imgMapper.selectImgsByAId(aId);
    }

    @Override
    public void insertImg(Img img) {
        imgMapper.insertImg(img);
    }
}
