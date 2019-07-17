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
	 * ���ֽ��������md5����
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
	 * ����MD5����
	 * @param tarString
	 * @return
	 */
	public static String md5(String tarString,String chartSet) {
		byte[] bytes = null;
		try {
			//������������ַ��������Ӧ�ı���Ȼ���ٽ���ת����md5����
			bytes = tarString.getBytes(chartSet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return md5(bytes);
	}

	/**
	 * ���ֽڵ�������16����
	 * 
	 * @param bytes
	 *            +128---��-128 129---��-127 ��-��=256 ���� ��=256+��
	 */
	private static String byteToOX(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			// ����ǰ���ֽ�������
			int number = bytes[i];
			if (number < 0) { // ��������Ǹ�������Ҫ����ת��������
				number = number + 256;
			}
			if (number < 16) { // ��������С��16��Ҫ��ǰ���0 �����ʹ���ֽ�������
				sb.append("0");
			}
			sb.append(Integer.toHexString(number));
		}
		return sb.toString();
	}

}
