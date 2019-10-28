package com.sts.blue.app_c.gate;

import com.alibaba.fastjson.JSON;
import com.sts.blue.app_c.fun_bearer.moudles.account.AccountControlEntrance;
import com.sts.blue.app_c.fun_test.TestControlEntrance;
import com.sts.blue.base_module.entity.bearer.account.Entity_req_login;
import io.netty.channel.ChannelId;
import org.springframework.stereotype.Service;

@Service
public class CallPortServerImpl implements CallPortServer {

    @Override
    public void doPort(String param, ChannelId channelId) {
        DoPortEntity entity = JSON.parseObject(param, DoPortEntity.class);
        switch (entity.getME()){
            case 0: //测试用
                TestControlEntrance testControlEntrance = new TestControlEntrance();
                testControlEntrance.doWebSocketTest(entity.getData(), channelId);
                break;
            case 1: //登录
                AccountControlEntrance entrance = new AccountControlEntrance();
                entrance.doLogin(entity.getData(), channelId);
                break;
        }
    }



}
