package com.sts.blue.app_m.gate;

import com.sts.blue.base_module.entity.Interaction.AppMRequestParame;
import com.sts.blue.base_module.listener.CallFunctionListener;

public interface CallEntryService {

    /**
     * 调用M层入口，通常可快速处理的请求可在listener的回调中将处理结果告知前端，
     * 若耗时较长的处理，则在listener中告知前端操作已提交请等待结果即可
     * */
    void callFunction(AppMRequestParame parame, CallFunctionListener listener);
}
