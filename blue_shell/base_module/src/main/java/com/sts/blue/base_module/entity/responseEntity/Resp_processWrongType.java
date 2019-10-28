package com.sts.blue.base_module.entity.responseEntity;

public enum Resp_processWrongType {
    // 没错
    NULL("N"),

    //通用错误类型
    GENERAL("G"),

    //数据错误
    WRONG_DATABASE("D"),

    ;

    private String value;

    Resp_processWrongType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
