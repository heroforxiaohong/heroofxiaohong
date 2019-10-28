package com.sts.blue.base_module.utils;

import com.alibaba.fastjson.JSON;
import com.sts.blue.base_module.exception.ContentFormatError;
import com.sts.blue.base_module.exception.ParamTypeError;
import com.sts.blue.base_module.static_value.annotation.EduExp;
import com.sts.blue.base_module.static_value.annotation.Enum_AnnoType;
import com.sts.blue.base_module.static_value.annotation.ForSQLClass;
import com.sts.blue.base_module.tools.AnnotationTool;
import com.sts.blue.base_module.utils.formatSQLService.FormatFunServer;
import com.sts.blue.base_module.utils.formatSQLService.FormatFunServerImpl_EduExp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FormatSQL {

    private static String ELEMENT_SEPARATION = ",";
    private static String ELEMENT_BEGIN = "[";
    private static String ELEMENT_END = "]";
    private static String KEY_LENGTH = "^";

    public static String Enc_countAndTableName(int count, String tableName){
        return count + ELEMENT_SEPARATION + tableName;
    }

    public static String[] Dec_countAndTableName(String compoundStr) throws ContentFormatError {
        if (null == compoundStr || compoundStr.trim().length() == 0){
            return null;
        }

        if (compoundStr.indexOf(ELEMENT_SEPARATION) == -1){
            throw new ContentFormatError("Dec_countAndTableName 格式错误");
        }

        String[] temp = compoundStr.split(ELEMENT_SEPARATION);

        if (temp.length!=2){
            throw new ContentFormatError("Dec_countAndTableName 格式错误");
        }

        return temp;
    }


    //----------------

    /**
     * 向sql保存数据时 将json变为sql中数据格式
     * */
    public static<T> String Enc_forSql(Class<T> jsonClazz, String jsonStr){
        List<T> objs = JSON.parseArray(jsonStr, jsonClazz);
        return Enc_forSql(jsonClazz, (T[])objs.toArray());
    }

    /**
     * 向sql保存数据时 将约定的对象数组变为sql中数据格式
     * */
    public static<T> String Enc_forSql(Class<T> clazz, T... Objs){
        if (!clazz.isAnnotationPresent(ForSQLClass.class)){
            throw new ParamTypeError("参数类型错误，未使用注解EduExpClass 定义此类型");
        }

        // 根据注解类型，获取对应的server实体
        FormatFunServer funServer = getFunServer(clazz.getAnnotation(ForSQLClass.class).value());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Objs.length; i++) {
            // 添加item
            sb.append(encodeItem(funServer.analysisItem(Objs[i])));
            if (i!=Objs.length-1){
                //添加分隔符
                sb.append(ELEMENT_SEPARATION);
            }
        }
        //以条目个数结尾
        sb.append(Objs.length);
        return sb.toString();
    }

    /**
     * 从sql数据库中获取数据后通过此方法得到json数据
     * */
    public static<T> String Dec_fromExp(String edxExpStr, Class<T> jsonClazz){
        if (edxExpStr==null||edxExpStr.trim().length()==0){
            return null;
        }

        StringBuilder sb = new StringBuilder(edxExpStr);

        int length = Integer.parseInt(sb.substring(edxExpStr.length()-1));

        String[] temp = new String[length];

        String itemKey;
        int index = 0, itemLength;
        for (int i = 0; i < length; i++) {
            itemKey = sb.substring(index+1, sb.indexOf(KEY_LENGTH, index));// index+1，跳过数组起始符号
            itemLength = itemKey.length()+2+Integer.parseInt(itemKey);// 数字长度+ [+^+记录的数据长度
            temp[i] = sb.substring(index+itemKey.length()+2, index+itemLength+1); //从^之后 到  ] 之前
            if (i != length-1){
                index = itemLength+2; //位置指到下一个[
            }
        }

        try {
            return Dec_fromExp(temp, jsonClazz);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从sql数据库中获取数据后通过此方法得到json数据
     * */
    public static<T> String Dec_fromExp(String[] edxExpStrList, Class<T> jsonClazz) throws IllegalAccessException, InstantiationException {
        if (!jsonClazz.isAnnotationPresent(ForSQLClass.class)){
            throw new ParamTypeError("参数类型错误，未使用注解EduExpClass 定义此类型");
        }

        if (edxExpStrList==null || edxExpStrList.length==0){
            return null;
        }

        FormatFunServer funServer = getFunServer(jsonClazz.getAnnotation(ForSQLClass.class).value());

        List<T> list = new ArrayList<>();

        T obj = null;
        String[] itemList = null;
        try {
            for (String itemStr : edxExpStrList) {
                obj = jsonClazz.newInstance();
                itemList = itemStr.split(ELEMENT_SEPARATION); // 通过分隔符，截取出每个item数据放到itemList中
                funServer.analysisObj(jsonClazz, itemList, obj);
                list.add(obj);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(list);
    }

    //========================================================================

    private static FormatFunServer getFunServer(Enum_AnnoType type){
        switch (type){
            case EDU_EXP:
                return new FormatFunServerImpl_EduExp();
        }

        return null;
    }

    /**
     * 将item元素拼接成一个串
     * */
    private static StringBuilder encodeItem(String...params){
        StringBuilder sb = new StringBuilder();
        sb.append(ELEMENT_BEGIN);

        for (int i = 0; i < params.length; i++) {
            sb.append(params[i]);
            if (i!=params.length-1){
                sb.append(ELEMENT_SEPARATION);
            }else {
                sb.append(ELEMENT_END);
            }
        }
        sb.insert(1,(sb.length()-2)+KEY_LENGTH);
        return sb;
    }

}
