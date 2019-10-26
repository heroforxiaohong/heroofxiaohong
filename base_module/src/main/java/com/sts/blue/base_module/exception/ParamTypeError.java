package com.sts.blue.base_module.exception;

/**
 * 参数类型异常时抛出
 * */
public class ParamTypeError extends RuntimeException {

    public ParamTypeError(String message) {
        super(message);
    }
}
