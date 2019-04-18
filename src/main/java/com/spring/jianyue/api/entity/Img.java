package com.spring.jianyue.api.entity;

import lombok.Data;

@Data
public class Img {
    private int id;
    private int aId;
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String img_url) {
        this.imgUrl = img_url;
    }
}
