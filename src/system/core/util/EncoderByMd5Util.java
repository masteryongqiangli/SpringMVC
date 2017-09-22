package system.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class EncoderByMd5Util {
	public static String endcoderByMd5Utile(String clearText){
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BASE64Encoder base64Encoder  = new BASE64Encoder();
		String cipherText = "";
		try {
			cipherText = base64Encoder.encode(messageDigest.digest(clearText.getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cipherText;
	}
}
