package com.spring.jianyue.api.entity.vo;

public class LikeVO {
    private Integer id;
    private Integer fromlikeUId;
    private Integer tolikeAId;
    private String title;
    private String nickname;
    private String avatar;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
