package com.gd.common.utils.date;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 日期格式
 *
 * @author Onpu
 * @date 2019-04-01
 */
public enum DatePattern {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    CN_DATE_BASIC_STYLE("yyyy-MM-dd HH:mm:ss"),
    /**
     * yyyy-MM-dd
     */
    CN_DATE_BASIC_STYLE1("yyyy-MM-dd"),
    /**
     * yyyy-MM
     */
    CN_DATE_BASIC_STYLE2("yyyy-MM"),
    /**
     * yyyy/MM/dd HH:mm:ss
     */
    CN_DATE_BASIC_STYLE3("yyyy/MM/dd HH:mm:ss"),
    /**
     * yyyy/MM/dd
     */
    CN_DATE_BASIC_STYLE4("yyyy/MM/dd"),
    /**
     * yyyyMMdd
     */
    CN_DATE_BASIC_STYLE5("yyyyMMdd"),
    /**
     * yyyyMM
     */
    CN_DATE_BASIC_STYLE6("yyyyMM"),
    /**
     * yyMM
     */
    CN_DATE_BASIC_STYLE7("yyMM"),
    /**
     * yyyy-MM-dd HH:mm
     */
    CN_DATE_BASIC_STYLE8("yyyy-MM-dd HH:mm"),
    /**
     * yyyy/MM/dd HH:mm
     */
    CN_DATE_BASIC_STYLE9("yyyy/MM/dd HH:mm"),
    /**
     * yyyyMMddHHmmssSSS
     */
    DATE_TIMESTAMP_STYLE("yyyyMMddHHmmssSSS"),
    /**
     * yyyyMMddHHmmss
     */
    DATE_TIMESTAMP_STYLE2("yyyyMMddHHmmss"),
    /**
     * yyyy-MM-dd'T'HH:mm:ssZZ
     */
    ISO_DATETIME_TIME_ZONE_FORMAT("yyyy-MM-dd'T'HH:mm:ssZZ"),
    /**
     * yyyy-MM-dd'T'HH:mm:ss
     */
    ISO_DATETIME_FORMAT("yyyy-MM-dd'T'HH:mm:ss"),
    /**
     * yyyy-MM-ddZZ
     */
    ISO_DATE_TIME_ZONE_FORMAT("yyyy-MM-ddZZ"),
    /**
     * 'T'HH:mm:ssZZ
     */
    ISO_TIME_TIME_ZONE_FORMAT("'T'HH:mm:ssZZ"),
    /**
     * 'T'HH:mm:ss
     */
    ISO_TIME_FORMAT("'T'HH:mm:ss"),
    /**
     * HH:mm:ssZZ
     */
    ISO_TIME_NO_T_TIME_ZONE_FORMAT("HH:mm:ssZZ"),
    /**
     * HH:mm:ss
     */
    ISO_TIME_NO_T_FORMAT("HH:mm:ss");

    private final String datePattern;

    DatePattern(final String datePattern) {
        this.datePattern = datePattern;
    }

    /**
     * 获取单个日期格式
     *
     * @return 日期格式
     */
    public String getDatePattern() {
        return this.datePattern;
    }

    /**
     * 获取所有日期格式
     *
     * @return 日期格式(按照默认声明顺序)
     */
    public static List<String> getDatePatterns() {
        return Arrays.stream(DatePattern.values())
                .map(DatePattern::getDatePattern)
                .collect(Collectors.toList());
    }
}
