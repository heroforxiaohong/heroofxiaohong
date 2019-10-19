package com.sts.blue.base_module.base.msg;


import java.io.Serializable;

/**
 * 消息
 * @author qingzhou
 * 2019-08-24
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 325123123738581347L;


    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
