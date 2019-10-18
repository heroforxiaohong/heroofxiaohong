package com.sts.blue.app_c.fun_bearer.moudles.account;

import com.sts.blue.app_c.fun_bearer.entity.responseEntity.Resp_result;
import com.sts.blue.base_module.entity.bearer.account.Entity_resp_login;

public class RespLogin extends Resp_result {

    private Entity_resp_login data;

    public Entity_resp_login getData() {
        return data;
    }

    public void setData(Entity_resp_login data) {
        this.data = data;
    }
}
