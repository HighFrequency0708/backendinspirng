package com.gd.common.utils.simple;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 过滤不合法字符串专用
 */
public class FilterUtil {

    /**
     * 过滤emoji表情
     * @param str
     * @return
     */
    public static String emojiFilter(String str) {
        if(str.trim().isEmpty()){
            return str;
        }
        String pattern="[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
        String reStr="";
        Pattern emoji= Pattern.compile(pattern);
        Matcher emojiMatcher=emoji.matcher(str);
        str=emojiMatcher.replaceAll(reStr);
        return str;
    }

}
