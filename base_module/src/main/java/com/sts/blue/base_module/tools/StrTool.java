package com.sts.blue.base_module.tools;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class StrTool {

    /**
     * 32位
     * */
    public static String getMD5(String str) {

        if (str!=null)
            return DigestUtils.md5DigestAsHex(str.getBytes());
        else
            return null;
    }

}
