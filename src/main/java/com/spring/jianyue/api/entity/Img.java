package com.spring.jianyue.api.entity;

import lombok.Data;

@Data
public class Img {
    private int id;
    private int a_id;
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String img_url) {
        this.imgUrl = img_url;
    }
}
