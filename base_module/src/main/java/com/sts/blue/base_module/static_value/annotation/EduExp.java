package com.sts.blue.base_module.static_value.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EduExp {
    Enum_EduExpMean value();
}
