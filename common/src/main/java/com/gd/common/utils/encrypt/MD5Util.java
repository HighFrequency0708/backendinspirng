package com.gd.common.utils.encrypt;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Locale;

public class MD5Util {

	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param origin
	 * @return
	 */
	public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
           // resultString = byteArrayToHexString(md.digest(resultString.getBytes()));//原文件内容，可能原因是：win2003时系统缺省编码为GBK，win7为utf-8
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));//正确的写法
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
	
	/**
	 *读取文件生成唯一的MD5码
     *
	 * @param path 要生成MD5码的文件路径
	 * @return 转换后的唯一的MD5码
	 */
	public static final String fileToMD5(String path) {
		BufferedInputStream bis = null;
		String fileMd5 = "";
		try {
			File file = new File(path);
			bis = new BufferedInputStream(new FileInputStream(file));
			fileMd5 = DigestUtils.md5Hex(bis);

		}catch (Exception me) {
			me.printStackTrace();
		}
		return fileMd5;
	}
	/**
	 * byte[]数组转换为16进制的字符串
	 *
	 * @param data 要转换的字节数组
	 * @return 转换后的结果
	 */
	public static final String byteArrayToHexString(byte[] data) {
	    StringBuilder sb = new StringBuilder(data.length * 2);
	    for (byte b : data) {
	        int v = b & 0xff;
	        if (v < 16) {
	            sb.append('0');
	        }
	        sb.append(Integer.toHexString(v));
	    }
	    return sb.toString().toUpperCase(Locale.getDefault());
	}
}
