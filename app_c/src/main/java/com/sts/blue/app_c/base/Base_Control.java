package com.sts.blue.app_c.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sts.blue.base_module.entity.responseEntity.RespMessage;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Handler;

public class Base_Control {

    protected void writeResult(HttpServletResponse response, RespMessage result){
        if (response==null){
            return;
        }

        if (!result.checkValid()){
            return;
        }
        String resp = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);

        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void writeResultObj(HttpServletResponse response, Object result){
        if (response==null){
            return;
        }

        String resp = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);

        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
