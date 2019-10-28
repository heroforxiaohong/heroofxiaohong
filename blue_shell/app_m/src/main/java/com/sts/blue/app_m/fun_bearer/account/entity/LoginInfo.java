package com.sts.blue.app_m.fun_bearer.account.entity;

import com.sts.blue.base_module.entity.bearer.account.Entity_resp_login;

public class LoginInfo extends Entity_resp_login {

    private String passwd;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
