package com.sts.blue.base_module.utils.formatSQLService;

import com.sts.blue.base_module.static_value.annotation.EduExp;
import com.sts.blue.base_module.tools.AnnotationTool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class FormatFunServerImpl_EduExp implements FormatFunServer {

    private Map<EduExp, String> map = null;

    @Override
    public String[] analysisItem(Object object) {
        // 获取 注解+变量值的 map
        Map<EduExp, Object> map = AnnotationTool.getVariableAnnoAndValue(object, EduExp.class);
        // 创建 临时存放的空间
        String[] temp = new String[6];
        for (EduExp key : map.keySet()) {
            switch (key.value()){
                case BEGIN_DATE:
                    temp[0] = (String) map.get(key);
                    break;
                case END_DATE:
                    temp[1] = (String) map.get(key);
                    break;
                case SCHOOL:
                    temp[2] = (String) map.get(key);
                    break;
                case EDU:
                    temp[3] = (String) map.get(key);
                    break;
                case DES:
                    temp[4] = (String) map.get(key);
                    break;
                case IS_MAX:
                    temp[5] = (String) map.get(key);
                    break;
            }
        }
        // 返回 变量值形成的数组
        return temp;
    }

    @Override
    public void analysisObj(Class clazz, String[] itemList, Object out) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if (map == null){
            // 获取 注解+变量名的 map
            map = AnnotationTool.getVariableAnnoAndName(clazz, EduExp.class);
        }
        Method method = null;
        String value = null;
        for (EduExp key : map.keySet()) {
            switch (key.value()){
                case BEGIN_DATE:
                    value = itemList[0];
                    break;
                case END_DATE:
                    value = itemList[1];
                    break;
                case SCHOOL:
                    value = itemList[2];
                    break;
                case EDU:
                    value = itemList[3];
                    break;
                case DES:
                    value = itemList[4];
                    break;
                case IS_MAX:
                    value = itemList[5];
                    break;
                default:
                    continue;
            }
            //反射获取set方法
            method = clazz.getMethod("set"+map.get(key).substring(0,1).toUpperCase()+map.get(key).substring(1), String.class);
            //通过反射赋值
            method.invoke(out, value);
        }

    }
}
