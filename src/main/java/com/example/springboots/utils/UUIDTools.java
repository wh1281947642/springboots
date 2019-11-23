package com.example.springboots.utils;

import java.util.Date;
import java.util.UUID;

/**
 * UUID 工具
 * @author Administrator
 *
 */
public class UUIDTools {

	/**
	 * 生成UUID
	 * @return 返回32位大写字符串
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	/**
	 * 生成时间戳 自1970年1月1日0时起至当前的毫秒数
	 * @return 
	 * @throws InterruptedException 
	 */
	public static String timestamp() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.valueOf(new Date().getTime());
	}
	
	public static void main(String[] args) {
	    UUIDTools uUIDTools =new UUIDTools();
	    System.out.println(uUIDTools.randomUUID());
		/*System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());*/
	}
}
