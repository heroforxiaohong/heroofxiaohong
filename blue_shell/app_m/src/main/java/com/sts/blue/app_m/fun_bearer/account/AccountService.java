package com.sts.blue.app_m.fun_bearer.account;

import com.sts.blue.base_module.entity.bearer.account.Entity_req_login;
import com.sts.blue.base_module.listener.CallFunctionListener;

public interface AccountService {

    void doLogin(Entity_req_login parame, CallFunctionListener listener);

}
