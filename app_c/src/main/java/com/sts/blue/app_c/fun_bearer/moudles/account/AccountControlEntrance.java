package com.sts.blue.app_c.fun_bearer.moudles.account;



import com.sts.blue.app_c.base.Base_Control;
import com.sts.blue.app_c.client.handler.NettySendUtils;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import com.sts.blue.base_module.static_value.M_ServiceType;
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

        AppMRequestParam param = new AppMRequestParam();
        param.setPortType(M_ServiceType.FUN_LOGIN);
        param.setParame(null);

        NettySendUtils.send(param);

        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("111123213");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
