package com.sts.blue.base_module.exception;

/**
 * 格式异常时抛出
 * */
public class ContentFormatError extends Exception {

    public ContentFormatError(String message) {
        super(message);
    }
}
