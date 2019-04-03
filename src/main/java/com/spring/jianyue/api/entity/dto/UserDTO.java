package com.spring.jianyue.api.entity.dto;

import lombok.Data;

@Data
public class UserDTO {
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String mobile;
    private String password;
}
