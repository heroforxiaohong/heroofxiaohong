package com.sts.blue.app_c.gmTest;

import com.sts.blue.app_c.AppCApplication;
import com.sts.blue.app_m.AppMApplication;
import com.sts.blue.app_m.customer_mapper.C_AccountLoginMapper;
import com.sts.blue.app_m.gate.CallEntryService;
import com.sts.blue.app_m.gate.CallEntryServiceImpl;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import com.sts.blue.base_module.listener.CallFunctionListener;
import com.sts.blue.base_module.static_value.M_ServiceType;
import com.sts.blue.base_module.tools.StrTool;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

public class CallMTest {
    @Test
    public void callM() {
//        SpringApplication.run(AppCApplication.class);
//        SpringApplication.run(AppMApplication.class);

        CallEntryService callEntryService = null;

        if (callEntryService == null){
            callEntryService = new CallEntryServiceImpl();
        }

        AppMRequestParam requestParame = new AppMRequestParam();
        requestParame.setPortType(M_ServiceType.FUN_LOGIN);
        requestParame.setParam("一个参数");

        callEntryService.callFunction(requestParame, new CallFunctionListener() {
            @Override
            public void onReturn(AppMResponseValue value) {
                int a = 1;
            }

            @Override
            public void onException(Exception e) {
                int a = 1;
            }
        });
    }

    @Test
    public void testMD5() {
        String md5 = StrTool.getMD5("123456");
        int a =1;
    }
}
