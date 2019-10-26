package com.sts.blue.base_module.utils.formatSQLService;

import java.lang.reflect.InvocationTargetException;

public interface FormatFunServer {

    /**
     * encode 向sql中存时，分析每条信息的内容
     * */
    String[] analysisItem(Object object);

    /**
     * decode 从sql向json转换时，将信息元素生产对应的json元对象
     * */
    void analysisObj(Class jsonClazz, String[] itemList, Object out) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException;

}
