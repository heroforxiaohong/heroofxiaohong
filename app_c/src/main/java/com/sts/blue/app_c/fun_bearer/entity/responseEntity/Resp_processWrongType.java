package com.sts.blue.app_c.fun_bearer.entity.responseEntity;

public enum Resp_processWrongType {
    NULL("N"),

    GENERAL("G"),

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
