package com.Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static void main(String[] args) {
		System.out.println(MD5Utils.md5("987456","UTF-8"));
		// e10adc3949ba59abbe56e057f20f883e
	}
	
	/**
	 * 将字节数组进行md5编码
	 * @param bytes
	 * @return
	 */
	public static String md5(byte[] bytes) {
		String result = "";
		try {
			MessageDigest mdInstance = MessageDigest.getInstance("md5");
			byte[] digest = mdInstance.digest(bytes);
			result = byteToOX(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 进行MD5编码
	 * @param tarString
	 * @return
	 */
	public static String md5(String tarString,String chartSet) {
		byte[] bytes = null;
		try {
			//将传入进来的字符串变成相应的编码然后再将其转换成md5编码
			bytes = tarString.getBytes(chartSet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return md5(bytes);
	}

	/**
	 * 将字节的数组变成16进制
	 * 
	 * @param bytes
	 *            +128---》-128 129---》-127 正-负=256 所以 正=256+负
	 */
	private static String byteToOX(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			// 将当前的字节数整数
			int number = bytes[i];
			if (number < 0) { // 如果该数是负数则需要将其转换成整数
				number = number + 256;
			}
			if (number < 16) { // 如果这个是小于16则要在前面加0 否则会使得字节数变少
				sb.append("0");
			}
			sb.append(Integer.toHexString(number));
		}
		return sb.toString();
	}

}
