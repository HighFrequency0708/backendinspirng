package com.gd.common.utils.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * BASE64转码
 */
public class Base64Util {

    /**
     * base 64 encode
     *
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }


    /**
     * base 64 encode
     *
     * @param str 待加密的string
     * @return
     */
    public static String base64Encode(String str) {
        byte[] bytes = str.getBytes();
        return new BASE64Encoder().encodeBuffer(bytes);
    }

    /**
     * base 64 decode
     *
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode(String base64Code) throws Exception {
        return base64Code.isEmpty() ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    public static String safeUrlBase64Encode(byte[] data) {

        String encodeBase64 = new BASE64Encoder().encode(data);

        String safeBase64Str = encodeBase64.replace('+', '-');

        safeBase64Str = safeBase64Str.replace('/', '_');

        safeBase64Str = safeBase64Str.replaceAll("=", "");

        return safeBase64Str;

    }


    public static byte[] safeUrlBase64Decode(final String safeBase64Str) throws IOException {

        String base64Str = safeBase64Str.replace('-', '+');

        base64Str = base64Str.replace('_', '/');

        int mod4 = base64Str.length() % 4;

        if (mod4 > 0) {

            base64Str = base64Str + "====".substring(mod4);

        }
        return new BASE64Decoder().decodeBuffer(base64Str);

    }
}
