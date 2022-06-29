package net.yorksolutions.jsontestremake;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	@JsonProperty("md5")
	String md5;

	public MD5(String md5) {

		if (md5 == null) {
			throw new RuntimeException("Please input a string to create MD5 hash");
		}

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes("UTF-8"));
			StringBuffer collector = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				collector.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			this.md5 = collector.toString();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("No instance of MD5" + e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Cannot translate UTF-8" + e.getMessage());
		}
	}
}

