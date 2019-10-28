package com.sts.blue.app_c.fun_bearer.moudles.account;



import com.alibaba.fastjson.JSON;
import com.sts.blue.app_c.base.Base_Control;
import com.sts.blue.app_c.tcp_client.handler.NettySendUtils;
import com.sts.blue.app_c.listener.SimpleCallBack;
import com.sts.blue.app_c.webSocket_server.WebSocketChannelContainer;
import com.sts.blue.app_c.webSocket_server.global.ChannelSupervise;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import com.sts.blue.base_module.entity.bearer.account.Entity_req_login;
import com.sts.blue.base_module.entity.bearer.account.Entity_resp_login;
import com.sts.blue.base_module.entity.responseEntity.RespMessage;
import com.sts.blue.base_module.entity.responseEntity.Resp_result;
import com.sts.blue.base_module.static_value.M_ServiceType;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/account", method = RequestMethod.POST)
public class AccountControlEntrance extends Base_Control {

    /**
     * 登录功能的http 入口
     * */
    @PostMapping(value = "/login")
    public void doLogin(HttpServletRequest request, final HttpServletResponse response, @RequestBody Entity_req_login reqLogin)
    {

        SimpleCallBack callBack = (SimpleCallBack<AppMResponseValue>) value -> {
            RespMessage result = new RespMessage(JSON.parseObject(value.getData(), Entity_resp_login.class), true, null);

            writeResult(response, result);
        };

        //调用实际处理方法
        doLogin(reqLogin, callBack);
    }

    /**
     * 登录功能的 webSocket 入口
     * */
    public void doLogin(String loginStr, ChannelId channelId){

        Entity_req_login login = JSON.parseObject(loginStr, Entity_req_login.class);

        SimpleCallBack callBack = (SimpleCallBack<AppMResponseValue>) value -> {
            Channel channel = ChannelSupervise.findChannel(channelId.asShortText());
            if (null!=channel && channel.isOpen()){

                RespMessage result = new RespMessage(JSON.parseObject(value.getData(), Entity_resp_login.class),true, null);

                String resultStr = JSON.toJSONString(result);
                TextWebSocketFrame tws = new TextWebSocketFrame(resultStr);

                channel.writeAndFlush(tws);
            }
        };

        //调用实际处理方法
        doLogin(login, callBack);
    }

    /**
     * 登录功能的实际控制方法
     * */
    private void doLogin(Entity_req_login login, SimpleCallBack<AppMResponseValue> callBack){
//        login.setLoginName("13265656565"); //测试
//        login.setLoginPasswd("123456");

        AppMRequestParam param = new AppMRequestParam();
        param.setPortType(M_ServiceType.FUN_LOGIN);
        param.setParam(login);

        NettySendUtils.send(param, callBack, "loginTag");
    }

}
