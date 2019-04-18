package com.spring.jianyue.api.entity;

import lombok.Data;

@Data
public class Like {
    private Integer id;
    private Integer fromlikeUId;
    private Integer tolikeAId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromlikeUId() {
        return fromlikeUId;
    }

    public void setFromlikeUId(Integer fromlikeUId) {
        this.fromlikeUId = fromlikeUId;
    }

    public Integer getTolikeAId() {
        return tolikeAId;
    }

    public void setTolikeAId(Integer tolikeAId) {
        this.tolikeAId = tolikeAId;
    }
}
