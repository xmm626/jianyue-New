package com.spring.jianyue.api.util;
import lombok.Data;

@Data
public class ResponseResult {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseResult error(int code, String msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        return responseResult;
    }

    public static ResponseResult success() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(StatusConst.SUCCESS);
        responseResult.setMsg(MsgConst.SUCCESS);
        return responseResult;
    }

    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(StatusConst.SUCCESS);
        responseResult.setMsg(MsgConst.SUCCESS);
        responseResult.setData(data);
        return responseResult;
    }
}

