package com.example.springboots.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
	
	/**
	 * 判断字符串是否为null或""
	 * @param o 字符串
	 * @return true or false
	 */
	public static boolean isNullOrEmpty(String o) {
		if(o == null || "".equals(o.trim())){
			return true;
		}
		return false;
	}
	
	/**
     * 判断list是否为null或空
     * @param list 
     * @return true or false
     */
    public static boolean isNotEmptyList(List<?> list) {
        if(list == null || list.size() == 0){
            return false;
        }
        return true;
    }
	
	/**
	 * 判断是否为手机号码
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		Pattern p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	
	/**
	 * 判断是否为email
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 拼接数组
	 * @author wuzhangshan
	 * @date 2017-2-13
	 * @param array
	 * @param split 分隔符
	 * @return
	 */
	public static String join(String[] array, String split) {
		StringBuffer sb = new StringBuffer();
		for (String str : array) {
			if(!StringTools.isNullOrEmpty(str)){
				sb.append(str + split);
			}
		}
		String string = sb.toString();
		if(string.length() > 0){
			return string.substring(0, string.length()-1);
		}
		return string;
	}
	/**
	 * 将32位主键转化成36位（-）
	 * @author wangwei
	 * @date   2017-12-14
	 * @param id
	 * @return
	 */
	public static String formatId(String id) {
		String returnId = null;
		if(id != null && id.length() == 32) {
			returnId = id.toLowerCase();
			return returnId.substring(0, 8) + "-" + 
					returnId.substring(8, 12) + "-" +
					returnId.substring(12, 16) + "-" + 
					returnId.substring(16, 20) + "-" +
					returnId.substring(20);
		}
		return returnId;
		
	}
	
	/**
	 * GUID编号
	 * @author wangwei
	 * @date   2017-12-14
	 * @param id
	 * @return
	 */
	public static String formatToGUID(String id) {
		return id == null ? null : String.format("{%s}", formatId(id));
	}
	
	/**
	 * 去掉html标签
	 * <功能详细描述>
	 * @param htmlStr
	 * @return
	 * @see
	 * @since 1.0
	 */
	public static String delHTMLTag(String htmlStr){ 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 
        
        htmlStr=htmlStr.replace(" ","");
        htmlStr=htmlStr.replaceAll("\\s*|\t|\r|\n","");
        htmlStr=htmlStr.replace("“","");
        htmlStr=htmlStr.replace("”","");
        htmlStr=htmlStr.replaceAll("　","");
          
        return htmlStr.trim(); //返回文本字符串 
    } 
	
	/**
	 * 处理可能为空的字符串对象
	 * <功能详细描述>
	 * @param obj
	 * @return
	 * @see
	 * @since 1.0
	 */
	public static String handleEmptyStr(Object obj){
	    String result = "";
	    if(obj != null){
	        result = obj.toString().trim();
	    }
	    return result; 
	}
}
