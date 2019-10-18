package com.sts.blue.base_module.entity.Interaction;

import com.sts.blue.base_module.static_value.M_ServiceType;

/**
 * c 调用 m 方法时，传入的参数值类型
 * */
public class AppMRequestParame {

    private M_ServiceType portType;

    private String parame;

    public M_ServiceType getPortType() {
        return portType;
    }

    public void setPortType(M_ServiceType portType) {
        this.portType = portType;
    }

    public String getParame() {
        return parame;
    }

    public void setParame(String parame) {
        this.parame = parame;
    }
}
