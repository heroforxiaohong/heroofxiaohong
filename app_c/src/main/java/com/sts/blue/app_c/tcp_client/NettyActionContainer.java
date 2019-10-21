package com.sts.blue.app_c.tcp_client;

import com.sts.blue.app_c.listener.SimpleCallBack;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import com.sts.blue.base_module.tools.StrTool;

import java.util.Date;
import java.util.HashMap;

public class NettyActionContainer {

    private static NettyActionContainer instance = new NettyActionContainer();

    public static NettyActionContainer getInstance(){
        return instance;
    }


    private int max = 60; //设置一个最大阀值，后期修改为根据M的CPU核数以及线程数自动生成

    private HashMap<String, SimpleCallBack> actionMap = new HashMap<>(20);

    public synchronized String produceAction(String token, SimpleCallBack action) throws BigWorkException, RepeatWorkException {
        if (actionMap.size() >= 60){
            throw new BigWorkException("服务器忙，请稍后重试");
        }

        if (actionMap.containsValue(action)){
            throw new RepeatWorkException("请求已提交，请勿重复操作");
        }

        String key = buildKey(token);

        actionMap.put(key, action);

        return key;
    }

    private String buildKey(String token){
        return StrTool.getMD5(token + new Date().getTime()+actionMap.size());
    }

    public synchronized void consumeAction(String key, AppMResponseValue value){
        if (actionMap.containsKey(key)){
            actionMap.remove(key).callBack(value);
        }
    }

    public void free(){
        actionMap = new HashMap<>(20);
    }

    public int getCurrentSize(){
        return actionMap.size();
    }
}
