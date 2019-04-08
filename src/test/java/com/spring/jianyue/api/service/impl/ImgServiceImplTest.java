package com.spring.jianyue.api.service.impl;

import com.spring.jianyue.api.entity.Img;
import com.spring.jianyue.api.mapper.ImgMapper;
import com.spring.jianyue.api.service.ImgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImgServiceImplTest {
    @Resource
    private ImgService imgService;

    @Test
    public void selectImgsByAId() {
        List<Img> imgs=imgService.selectImgsByAId(1);
        System.out.println(imgs);
    }
}