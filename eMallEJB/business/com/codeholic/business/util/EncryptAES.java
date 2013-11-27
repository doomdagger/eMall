package com.codeholic.business.util;

import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.ibm.crypto.provider.IBMJCE;

public class EncryptAES {

//	// KeyGenerator 提供对称密钥生成器的功能，支持各种算法
//	private static KeyGenerator keygen;
	// SecretKey 负责保存对称密钥
	private static SecretKey deskey;
	// Cipher负责完成加密或解密工作
	private static Cipher c;
	// 该字节数组负责保存加密的结果
	private static byte[] cipherByte;

	static {
		Security.addProvider(new IBMJCE());
		// 实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
//		try {
//			keygen = KeyGenerator.getInstance("AES");
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		// 生成密钥
//		deskey = keygen.generateKey();
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(EncryptAES.class.getResourceAsStream("key_gen.dat"));
			deskey = (SecretKey)inputStream.readObject();
			inputStream.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 生成Cipher对象,指定其支持的DES算法
		try {
			c = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对字符串加密
	 * 
	 * @param str
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] Encrytor(String str) throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		// 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
		c.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] src = str.getBytes();
		// 加密，结果保存进cipherByte
		cipherByte = c.doFinal(src);
		return cipherByte;
	}

	/**
	 * 对字符串解密
	 * 
	 * @param buff
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] Decryptor(byte[] buff) throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		// 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
		c.init(Cipher.DECRYPT_MODE, deskey);
		cipherByte = c.doFinal(buff);
		return cipherByte;
	}

	/**
	 * @param args
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidKeyException
	 */
	public static void main(String[] args) throws Exception {
		String msg = "1234";
		String encodedString = encode(msg);
		System.out.println("明文是:" + msg);
		System.out.println("加密后:" + encodedString);
		System.out.println("解密后:" + decode("efb40540970c9f2cfc401ff9cf0ff5205ef7afc9f89f820d"));
		
	}

	public static String encode(String msg) throws Exception {
		byte[] encontent = Encrytor(msg);
		String encodedPass = byteArrayToHexString(encontent);
		return encodedPass;
	}

	public static String decode(String msg) throws Exception {
		byte[] decontent = EncryptAES
				.Decryptor(hexStringToByteArray(msg));
		return new String(decontent);
	}

	public static byte hexCharsToByte(String ch1, String ch3, String ch2) {
		int pre = findIndexInArray(ch1);
		int post = findIndexInArray(ch2);

		int n = pre * 16 + post;

		if (ch3.equals("f")) {
			n -= 256;
		}

		return (byte) n;
	}

	public static byte[] hexStringToByteArray(String string) {
		ArrayList<Byte> list = new ArrayList<Byte>();
		for (int i = 0; i < string.length(); i += 3) {
			list.add(hexCharsToByte(string.charAt(i) + "", string.charAt(i + 1)
					+ "", string.charAt(i + 2) + ""));
		}
		byte[] bytes = new byte[list.size()];

		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = list.get(i);
		}

		return bytes;
	}

	public static int findIndexInArray(String string) {
		int i = 0;
		for (String str : hexDigits) {
			if (str.equals(string)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;

		int d3 = 0;

		if (n < 0) {
			n = 256 + n;
			d3 = 15;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d3] + hexDigits[d2];
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

}
