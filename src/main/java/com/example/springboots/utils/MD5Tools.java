package com.example.springboots.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具
 * 
 * @author Administrator
 * 
 */
public abstract class MD5Tools {

	private MD5Tools() throws IllegalAccessException {
		throw new IllegalAccessException("MD5Tools不能被实例化");
	}

	private static MessageDigest messagedigest;
	private static char MD5_CHARS[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 获取指定File的MD5码
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String getFileMD5(File file) throws NoSuchAlgorithmException,
			IOException {
	    FileInputStream in = new FileInputStream(file);
	    try {
	        messagedigest = MessageDigest.getInstance("MD5");
	        FileChannel ch = in.getChannel();
	        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
	            file.length());
	        messagedigest.update(byteBuffer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(in != null){
                in.close();
            }
        }
	    return bufferToHex(messagedigest.digest());
	}
	
	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param file
	 * @return
	 * @see
	 * @since 1.0
	 */
    public static String getMD5Byte(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] b = md.digest();
            return bufferToHex(b);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                fis.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    } 

	/**
	 * 获取指定字符串的MD5码
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public static String getStringMD5(String str)
			throws NoSuchAlgorithmException {
		messagedigest = MessageDigest.getInstance("MD5");
		messagedigest.update(str.getBytes());
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * 验证一个字符串的MD5码,与指定的MD5码是否相等
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean check(String str, String md5)
			throws NoSuchAlgorithmException {
		return getStringMD5(str).equals(md5);
	}

	/**
	 * 验证一个FILE的MD5码,与指定的MD5码是否相等
	 * 
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean check(File f, String md5)
			throws NoSuchAlgorithmException, IOException {
		return getFileMD5(f).equals(md5);
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = MD5_CHARS[(bt & 0xf0) >> 4];
		char c1 = MD5_CHARS[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static void main(String[] args) {
		try {
			String str = MD5Tools.getStringMD5("123456");
			System.out.println(str);
			System.out.println(str.length());
			int num = 0;
			for (char c : str.toCharArray()) {
				num += c;
			}
			System.out.println(num % 1000 % 100);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
