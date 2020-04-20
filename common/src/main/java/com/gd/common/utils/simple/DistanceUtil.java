package com.gd.common.utils.simple;

import java.math.BigDecimal;

public class DistanceUtil {
    /**
     * 定义 地球半径
     */
    private static final BigDecimal EARTH_RADIUS = new BigDecimal(6378.137);

    /**
     * 定义 Math.PI
     */
    private static final BigDecimal MATH_PI = new BigDecimal(Math.PI);

    /**计算弧长**/
    private static BigDecimal getRed(BigDecimal big){
        return big.multiply(MATH_PI).divide(new BigDecimal(180), BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal format(BigDecimal big, int scale) {
        scale = 0 > scale ? 0 : scale;
        big = big.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return big;
    }

    /**
     * 计算 两点 之间  的 最短距离 <br/>
     * 返回 数据 为 两点之间的 公里数
     */
    public static BigDecimal getShortestDistance(BigDecimal lat1,BigDecimal lng1,
                                                 BigDecimal lat2,BigDecimal lng2 ){

        BigDecimal radLat1 = getRed(lat1);
        BigDecimal radLat2 = getRed(lat2);
        BigDecimal a = radLat1.subtract(radLat2);
        BigDecimal b = getRed(lng1).subtract(getRed(lng2));

        Double sinA = Math.sin(a.doubleValue()/2);
        Double sinB = Math.sin(b.doubleValue()/2);
        Double cosA = radLat1.doubleValue();
        Double cosB = radLat2.doubleValue();

        Double obj = 2 * Math.asin(Math.sqrt(Math.pow(sinA,2) + Math.cos(cosA)*Math.cos(cosB)*Math.pow(sinB, 2)));
        BigDecimal s = new BigDecimal(obj);
        s = s.multiply(EARTH_RADIUS);
        return format(s, 3);
    }
}
