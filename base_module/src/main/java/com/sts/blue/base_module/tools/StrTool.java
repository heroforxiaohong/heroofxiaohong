package com.sts.blue.base_module.tools;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

public class StrTool {

    static final Base64.Encoder encoderBase64 = Base64.getEncoder();
    static final Base64.Decoder decoderBase64 = Base64.getDecoder();


    /**
     * 32位
     * */
    public static String getMD5(String str) {

        if (str!=null)
            return DigestUtils.md5DigestAsHex(str.getBytes());
        else
            return null;
    }

    public static String encodeBase64(String str){
        return encoderBase64.encodeToString(str.getBytes());
    }

    public static String decodeBase64(String base64Str){
        return new String(decoderBase64.decode(base64Str));
    }

}
