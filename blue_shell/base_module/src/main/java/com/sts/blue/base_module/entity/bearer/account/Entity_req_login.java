package com.sts.blue.base_module.entity.bearer.account;

public class Entity_req_login {

    private String loginName;

    private String loginPasswd;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPasswd() {
        return loginPasswd;
    }

    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd;
    }
}
