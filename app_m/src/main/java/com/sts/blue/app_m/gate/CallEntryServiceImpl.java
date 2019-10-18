package com.sts.blue.app_m.gate;

import com.sts.blue.app_m.fun_bearer.account.AccountService;
import com.sts.blue.app_m.fun_bearer.account.AccountServiceImpl;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParame;
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
     * @param parame 传入参数
     * @param listener 事件处理后的回调实体
     * */
    public void callFunction(AppMRequestParame parame, CallFunctionListener listener){
        if (parame.getPortType()!=null){
            doFunction(parame, listener);
        }else {
            if (listener != null){
                listener.onException(new Exception("未定义PortCode"));
            }else {
                try {
                    throw new Exception("CallEntryService.java - callFunction . parame is error");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doFunction(AppMRequestParame parame, CallFunctionListener listener){
        switch (parame.getPortType()){
            case FUN_LOGIN:
                if (accountService == null){
                    accountService = new AccountServiceImpl();
                }
                accountService.doLogin(parame.getParame(), listener);
                break;
        }
    }
}
