package com.sts.blue.app_c.fun_bearer.moudles.account;



import com.sts.blue.app_c.base.Base_Control;
import com.sts.blue.app_c.client.handler.NettySendUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/account", method = RequestMethod.POST)
public class AccountControlEntrance extends Base_Control {

//    private CallEntryService callEntryService = null;

    @PostMapping(value = "/login")
//    public void doLogin(HttpServletRequest request, final HttpServletResponse response, @RequestBody Entity_req_login param)
    public void doLogin(HttpServletRequest request, final HttpServletResponse response)
    {
//        if (callEntryService == null){
//            callEntryService = new CallEntryServiceImpl();
//        }
//
//        if (null == param){
//
//        }

//        new Thread()

//        NettyClient client = new NettyClient();
//        try {
//            client.run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        NettySendUtils.send();

        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("111123213");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        AppMRequestParame requestParame = new AppMRequestParame();
//        requestParame.setPortType(M_ServiceType.FUN_LOGIN);
//        requestParame.setParame("一个参数");

//        callEntryService.callFunction(requestParame, new CallFunctionListener() {
//            @Override
//            public void onReturn(AppMResponseValue value) {
//                //返回数据给前端 或 给予前端提示信息
//                RespMessage respMessage = new RespMessage();
//                if (true){
//                    respMessage.setProcessResult(true);
//                }
//                writeResult(response, respMessage);
//            }
//
//            @Override
//            public void onException(Exception e) {
//                //异常提示或操作
//            }
//        });

    }



}
