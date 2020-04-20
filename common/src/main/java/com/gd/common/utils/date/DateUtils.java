package com.gd.common.utils.date;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Onpu
 * @date 2019-04-01
 */
public class DateUtils {

    /**
     * 日期转换成指定格式日期字符串
     *
     * @param date 日期
     * @return 返回yyyy-MM-dd格式日期字符串
     */
    public static String formatDate(final Date date) {
        return formatDateByStyle(date, DatePattern.CN_DATE_BASIC_STYLE1.getDatePattern());
    }

    /**
     * 当前日期转换成指定格式日期字符串
     *
     * @return 返回yyyy-MM-dd格式日期字符串
     */
    public static String formatNowDate() {
        return formatNowByStyle(DatePattern.CN_DATE_BASIC_STYLE1.getDatePattern());
    }

    /**
     * 日期转换成指定格式日期字符串
     *
     * @param date 日期
     * @return 返回yyyy-MM-dd HH:mm:ss格式日期字符串
     */
    public static String formatDateTime(final Date date) {
        return formatDateByStyle(date, DatePattern.CN_DATE_BASIC_STYLE.getDatePattern());
    }

    /**
     * 当前日期转换成指定格式日期字符串
     *
     * @return 返回yyyy-MM-dd HH:mm:ss格式日期字符串
     */
    public static String formatNowDateTime() {
        return formatNowByStyle(DatePattern.CN_DATE_BASIC_STYLE.getDatePattern());
    }

    /**
     * 日期转换成指定格式日期字符串
     *
     * @param date        日期
     * @param datePattern 日期格式
     * @return 返回指定格式日期字符串
     */
    public static String formatDateByStyle(final Date date, final String datePattern) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
            return sdf.format(date);
        }
        return null;
    }

    /**
     * 当前日期转换成指定格式日期字符串
     *
     * @param datePattern 日期格式
     * @return 返回指定格式日期字符串
     */
    public static String formatNowByStyle(final String datePattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePattern);
        return dtf.format(LocalDateTime.now());
    }

    /**
     * 指定格式日期字符串转换成日期
     *
     * @param dateStr     指定格式日期字符串
     * @param datePattern 日期格式
     */
    public static Date formatStringByStyleToDate(final String dateStr, final String datePattern) {
        Date date = null;
        if (StringUtils.isNotBlank(dateStr)) {
            SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
            try {
                date = formatter.parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date    日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(final Date date, final int seconds) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusSeconds(seconds));
    }

    /**
     * 当前日期的【秒】进行加/减
     *
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addNowSeconds(final int seconds) {
        return localDateTimeToDate(LocalDateTime.now().plusSeconds(seconds));
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date    日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(final Date date, final int minutes) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusMinutes(minutes));
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(final int minutes) {
        return localDateTimeToDate(LocalDateTime.now().plusMinutes(minutes));
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date  日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(final Date date, final int hours) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusHours(hours));
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(final int hours) {
        return localDateTimeToDate(LocalDateTime.now().plusHours(hours));
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(final Date date, final int days) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusDays(days));
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(final int days) {
        return localDateTimeToDate(LocalDateTime.now().plusDays(days));
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date  日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(final Date date, final int weeks) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusWeeks(weeks));
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(final int weeks) {
        return localDateTimeToDate(LocalDateTime.now().plusWeeks(weeks));
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date   日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(final Date date, final int months) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusMonths(months));
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(final int months) {
        return localDateTimeToDate(LocalDateTime.now().plusMonths(months));
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date  日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(final Date date, final int years) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusYears(years));
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addNowYears(final int years) {
        return localDateTimeToDate(LocalDateTime.now().plusYears(years));
    }

    /**
     * Date转LocalDateTime
     *
     * @param date 日期
     * @return 日期
     */
    public static LocalDateTime dateToLocalDateTime(final Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转Date
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static Date localDateTimeToDate(final LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得本月的第一天的0点
     * @return
     */
    public static Date firstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return  calendar.getTime();
    }

    /**
     * 获得本月的最后一天
     * @return
     */
    public static Date lastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.HOUR,24);
        return  calendar.getTime();
    }
}
