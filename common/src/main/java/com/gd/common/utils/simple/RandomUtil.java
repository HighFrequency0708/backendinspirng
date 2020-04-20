package com.gd.common.utils.simple;


import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:生成随机字符串或者随机数字
 * @Date:9:14 2018/12/13
 */
public class RandomUtil {

    private static int sequence = 0;
    private static int length = 6;
    private static int maxIntLength = 9;


    /**
     *@description:生成随机字符串UUID，去'-'
     *@Date:9:14 2018/12/13
     */
    public static String uuidRandom() {
        return UUID.randomUUID().toString().replaceAll("\\-", "");
    }

    /**
     *@description:生成count位随机字符串
     *@param:[count]
     *@Date:9:14 2018/12/13
     */
    public static String codeRandom(int count){
        StringBuilder sb = new StringBuilder();
        String baseString = "abcdefghijklmnopqrstuvwxyz0123456789";
        int baseLength = baseString.length();
        if (count < 1) {
            count = 1;
        }
        for(int i = 0; i < count; ++i) {
            int number = ThreadLocalRandom.current().nextInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();

    }

    /**
    *@Description:生成count位随机数字
    *@param:[count]
    *@Date:9:46 2018/12/13
    */
    public static String numberRandon(int count){
        StringBuilder sb = new StringBuilder();
        String baseString = "0123456789";
        int baseLength = baseString.length();
        if (count < 1) {
            count = 1;
        }
        for(int i = 0; i < count; ++i) {
            int number = ThreadLocalRandom.current().nextInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }

}
