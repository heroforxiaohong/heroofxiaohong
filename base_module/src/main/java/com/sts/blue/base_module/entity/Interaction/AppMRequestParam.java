package com.sts.blue.base_module.entity.Interaction;

import com.alibaba.fastjson.JSON;
import com.sts.blue.base_module.static_value.M_ServiceType;

/**
 * c 调用 m 方法时，传入的参数值类型
 * */
public class AppMRequestParam {

    private M_ServiceType portType;

    private String param;

    public M_ServiceType getPortType() {
        return portType;
    }

    public void setPortType(M_ServiceType portType) {
        this.portType = portType;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setParam(Object param) {
        this.param = JSON.toJSONString(param);
    }
}
