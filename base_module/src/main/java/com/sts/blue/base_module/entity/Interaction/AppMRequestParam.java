package com.sts.blue.base_module.entity.Interaction;

import com.sts.blue.base_module.static_value.M_ServiceType;

/**
 * c 调用 m 方法时，传入的参数值类型
 * */
public class AppMRequestParam {

    private M_ServiceType portType;

    private Object param;

    public M_ServiceType getPortType() {
        return portType;
    }

    public void setPortType(M_ServiceType portType) {
        this.portType = portType;
    }

    public Object getParame() {
        return param;
    }

    public void setParame(Object param) {
        this.param = param;
    }
}
