package com.gd.common.utils.encrypt;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者 yuansf
 * @version 创建时间：2016年8月4日 下午6:21:03 
 * 签名
 */
public class SignUtil {

	/**
	 * 得到签名
	 * @param requestURI 请求相对地址
	 * @param queryString 请求URL后的变量及其值
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	public static String findSign(String requestURI, String queryString, String secret) throws Exception {
		String[] urls = queryString.split("&");
		return Signing(requestURI, urls, secret);
	}

	/**
	 * 签名
	 * @param urls
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	private static String Signing(String requestURI, String[] urls, String secret)
			throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		for (int i = 0; i < urls.length; i++) {
			String[] item = urls[i].split("=",2);
			params.put(item[0], item.length < 2 ? StringUtils.EMPTY : item[1]);			
		}
		params.remove("sign");

		// 第一步：检查参数是否已经排序
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		// 第二步：把所有参数名和参数值串在一起
		StringBuilder strBuilder = new StringBuilder();
		//1:加入请求相对地址
		strBuilder.append(requestURI);
		//2:加入请求URL后的变量及其值
		for (String key : keys) {
			String value = params.get(key);
			strBuilder.append(key).append(value);
		}

		// 第三步：使用MD5/HMAC加密
		byte[] bytes = encryptHMAC(strBuilder.toString(), secret);
		// 第四步：把二进制转化为大写的十六进制
		return byte2hex(bytes);
	}

	/**
	 * 加密
	 * @param data
	 * @param secret
	 * @return
	 * @throws IOException
	 */
	private static byte[] encryptHMAC(String data, String secret)
			throws IOException {
		byte[] bytes = null;
		try {
			SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF-8"),
					"HmacMD5");
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			bytes = mac.doFinal(data.getBytes("UTF-8"));
		} catch (GeneralSecurityException gse) {
		}
		return bytes;
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}
}
