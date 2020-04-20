package com.gd.common.utils.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES加密
 */
public class AESUtil {

    // 加密方式
    public final static String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    //  IvParameter
    public final static String IVPARAMETERSPEC = "2018011810460000";
    //  随机算法
    public final static String SECURERANDOMPARAM = "SHA1PRNG";
    //  固定秘钥(私钥1)
    public final static String SECRET = "gdiot201801";
    //  固定秘钥(私钥2)
    public final static String SECRET2 = "gdiot20180417b";
    /**
     * 客户端ID 占用位数
     */
    public final static int CLIENT_ID_PREFIX_DIGIT = 1;

    /**
     * 加密 (先Aes加密再Base64)
     *
     * @param content
     * @param strKey
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String strKey) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey + SECRET);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        IvParameterSpec iv = new IvParameterSpec(IVPARAMETERSPEC.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes());
        return Base64Util.safeUrlBase64Encode(encrypted);
    }

    /**
     * 解密
     *
     * @param strKey
     * @param encryptStr
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptStr, String strKey) throws Exception {
        byte[] content = Base64Util.safeUrlBase64Decode(encryptStr);
        SecretKeySpec skeySpec = getKey(strKey + SECRET);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        IvParameterSpec iv = new IvParameterSpec(IVPARAMETERSPEC.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(content);
        String originalString = new String(original);
        return originalString;
    }

    private static SecretKeySpec getKey(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes();
        byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）

        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");
        return skeySpec;
    }

    /**
     * sign加密的公钥
     *
     * @return
     */
    public static Long getRandomSecret() {
        try {
            SecureRandom random = SecureRandom.getInstance(SECURERANDOMPARAM);
            return random.nextLong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return Long.parseLong("20180118");
        }
    }
}
