package com.wanghuadi.utils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/*
 *  1.	判断源字符串是否有值，空引号也算没值
	2.	判断源字符串是否有值，空引号和空格也算没值
	3.	判断是否为手机号码
	4.	判断是否为电子邮箱
	5.	判断是否全部为字母
	6.	获取n位随机英文字符串
	7.	获取n位随机英文和数字字符串
	8.	获取n个随机中文字符串
 */
public class StringUtil {

	/**
	 *  1.	判断源字符串是否有值，空引号也算没值
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null || str.trim().length() < 1;
	}
	
	/**
	 * 3.判断是否为手机号码
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		String regex = "1[3|4|5|7|9]\\d{9}";
		return str.matches(regex);
	}
	
	
	
	/**
	 *  4.判断是否为电子邮箱
	 * @param args
	 */
	public static boolean isEmail(String str){
		String regex = "\\w+@\\w+(.com|.cn|.cn.com)";
		return str.matches(regex);
	}
	
	/**
	 * 5.判断是否全部为字母
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		String regex = "[a-zA-Z]+";
		return str.matches(regex);
	}
	
	/**
	 * 6.	获取n位随机英文字符串
	 */
	public static String getStringRandom(int length){
		char[] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		Random rm = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int nextInt = rm.nextInt(26);
			String str = words[nextInt]+"";
			
			int nextInt2 = rm.nextInt();
			if(nextInt2%2 == 0){
				str = str.toLowerCase();
			}
			sb.append(str);
		}
		return sb.toString();
	} 
	
	
	/*
	 * 6.	获取n位随机英文字符串
	 * */
	public static String getStringRandom2(int length){
		Random rm = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			/*	65-90	A-Z
				97-122	a-z
			*/
			int num = rm.nextInt(123);
			if(num >=65 && num <=90 || num>=97 && num <=122){
				char c = (char) num;
				sb.append(c);
			}else{
				i--;
			}
		}
		return sb.toString();
	} 
	
	/*
	 * 7.	获取n位随机英文和数字字符串
	 */
	public static String getStringNumber(int length){
		Random rm = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = rm.nextInt(123);
			if(num >=65 && num <=90 || num>=97 && num <=122 || num>=48 && num <=57){
				char c = (char) num;
				sb.append(c);
			}else{
				i--;
			}
		}
		return sb.toString();
	} 
	
	/*
		8.	获取n个随机中文字符串
	*/

	/**
	 * 获取n个随机中文字符串
	 * @return
	 */
	public static String getAChinese(int length) {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < length ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
  }
  
	/*
	 * 判断是否是小数
	 */
	public static boolean isFloat(String str){
		String reg = "[0-9]+\\.[0-9]+";
		return str.matches(reg);
	}
	
	/*
	 * 判断是否是数字
	 */
	public static boolean isNumber(String str){
		String regex = "(\\d+)|([0-9]+\\.[0-9]+)";
		return str.matches(regex);
	}

	/*
	 * 判断字符串是否是日期类型
	 */
	public static boolean isDate(String idate){
		   String format = "([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
		   return idate.matches(format);
	}
}
