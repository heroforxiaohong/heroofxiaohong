package com.sts.blue.base_module.entity.Interaction;

import com.alibaba.fastjson.JSON;

/**
 * c 调用 m 方法时，m返回此类型结果
 * */
public class AppMResponseValue {

    private int type;

    private String msg;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = JSON.toJSONString(data);
    }

    public void setData(String data){
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
