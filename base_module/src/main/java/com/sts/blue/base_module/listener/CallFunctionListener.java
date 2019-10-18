package com.sts.blue.base_module.listener;

import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;

/**
 * c 调用 m 方法时设置的回调方法
 * */
public interface CallFunctionListener {

    void onReturn(AppMResponseValue value);// 正常回调

    void onException(Exception e); // 出现异常时回调

}
