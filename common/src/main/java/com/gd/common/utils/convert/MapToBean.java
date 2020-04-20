package com.gd.common.utils.convert;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 作者 duxd 
 * @version 创建时间：2016年7月6日 下午1:49:13 
 * 类说明 
 */

public class MapToBean {
	 /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException
     *             如果分析类属性失败
     * @throws IllegalAccessException
     *             如果实例化 JavaBean 失败
     * @throws InstantiationException
     *             如果实例化 JavaBean 失败
     * @throws InvocationTargetException
     *             如果调用属性的 setter 方法失败
	 * @throws ParseException 
     */
	public static Object convertMap(@SuppressWarnings("rawtypes") Class type, Map<String, Object> map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException, ParseException {
		if (map == null || map.size() == 0) {
			return null;
		}
		
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象
        
		Map<String, Object> tmpMap = new HashMap<String, Object>();
        //将map中的key都转化为小写		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			tmpMap.put(key.toLowerCase(), map.get(key));
		}
		
        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName().toLowerCase();

            if (tmpMap.containsKey(propertyName.toLowerCase(Locale.getDefault()))) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = tmpMap.get(propertyName);

                Object[] args = new Object[1];
                Class<?> valPropertyClass = descriptor.getPropertyType();
                String className = valPropertyClass.getName();
                if (className.indexOf("Integer") != -1 || className.indexOf("int") != -1) {
                	args[0] = Integer.parseInt(value.toString());
                } 
                else if (className.indexOf("Long") != -1 || className.indexOf("long") != -1) {
                	args[0] = Long.parseLong(value.toString());
                }
                else if (className.indexOf("Double") != -1 || className.indexOf("double") != -1) {
                	args[0] = Double.parseDouble(value.toString());
                }else if (className.indexOf("Short") != -1 || className.indexOf("short") != -1) {
                	args[0] = Short.parseShort(value.toString());
                }
                else if (className.indexOf("Boolean") != -1 || className.indexOf("boolean") != -1) {
                	args[0] = Boolean.parseBoolean(value.toString());
                }
                else if (className.indexOf("Date") != -1) {
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                	String timestamp = value.toString().substring(value.toString().indexOf("(") + 1, value.toString().indexOf(")"));
                	Date date = dateFormat.parse(dateFormat.format(Long.parseLong(timestamp)));
                	args[0] = date;
                }
                else {
                	args[0] = value;
                }

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

}
