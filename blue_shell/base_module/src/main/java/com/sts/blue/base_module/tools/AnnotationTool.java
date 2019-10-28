package com.sts.blue.base_module.tools;

import com.sts.blue.base_module.static_value.annotation.EduExp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AnnotationTool {

    public static<T extends Annotation, K> Map<T, Object> getVariableAnnoAndValue(Object obj, Class<T> intentAnno){
        Class<K> clazz_ = (Class<K>) obj.getClass();
        Map<T, Object> tempMap = null;
        Field[] fields = clazz_.getDeclaredFields();
        if (fields.length>0){
            tempMap = new HashMap<>((fields.length/3 * 4)+1);
        }

        for(Field field: fields){
            field.setAccessible(true);
            if(field.isAnnotationPresent(intentAnno)){
                T annotation = field.getAnnotation(intentAnno);
                try {
                    tempMap.put(annotation, field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    tempMap.put(annotation, null);
                }
            }
        }

        return tempMap;
    }

    public static<T extends Annotation> Map<T, String> getVariableAnnoAndName(Class clazz, Class<T> intentAnno){
        Map<T, String> tempMap = null;
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length>0){
            tempMap = new HashMap<>((fields.length/3 * 4)+1);
        }

        for(Field field: fields){
            field.setAccessible(true);
            if(field.isAnnotationPresent(intentAnno)){
                T annotation = field.getAnnotation(intentAnno);
                tempMap.put(annotation, field.getName());
            }
        }
        return tempMap;
    }


}
