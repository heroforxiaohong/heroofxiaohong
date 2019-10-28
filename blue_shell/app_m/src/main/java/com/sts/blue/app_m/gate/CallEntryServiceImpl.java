package com.sts.blue.app_m.gate;

import com.alibaba.fastjson.JSON;
import com.sts.blue.app_m.fun_bearer.account.AccountService;
import com.sts.blue.app_m.fun_bearer.account.AccountServiceImpl;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import com.sts.blue.base_module.entity.bearer.account.Entity_req_login;
import com.sts.blue.base_module.listener.CallFunctionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 调用M 下方法入口的实现类
 * */
@Service
public class CallEntryServiceImpl implements CallEntryService{

    @Autowired
    private AccountService accountService = null;

    /**
     * 调用入口
     * @param param 传入参数
     * @param listener 事件处理后的回调实体
     * */
    public void callFunction(AppMRequestParam param, CallFunctionListener listener){
        if (param.getPortType()!=null){
            doFunction(param, listener);
        }else {
            if (listener != null){
                listener.onException(new Exception("未定义PortCode"));
            }else {
                try {
                    throw new Exception("CallEntryService.java - callFunction . param is error");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *
     * 业务功能入口  增加一个业务功能，则增加一个case ，以及多一个对应的PortType
     *
     * */
    private void doFunction(AppMRequestParam param, CallFunctionListener listener){
        switch (param.getPortType()){
            case FUN_LOGIN:
                if (accountService == null){
                    accountService = new AccountServiceImpl();
                }

                //将参数 转为Entity_req_login.class 对象，并开始业务处理  当其它功能时转为对应的实体对象即可
                accountService.doLogin(JSON.parseObject(param.getParam(), Entity_req_login.class), listener);
                break;
        }
    }
}
