package com.sts.blue.base_module.entity.responseEntity;

public class Resp_result {

    private int code; // 返回结果码
    private String msg; // 该结果码对应的提示内容等，一般用于弹框给用户看

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
}
