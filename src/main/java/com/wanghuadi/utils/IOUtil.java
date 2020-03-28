package com.wanghuadi.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * 	获取文件扩展名
	删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	获取操作系统用户目录
	返回文件以指定单位大小表示
 */
public class IOUtil {
	
	/**
	 * 解析文件
	 * @param filePath  文件路径
	 * @param splitstring	切割 符号
	 * @return
	 */
	public static List<Object[]> readFile(String filePath,String splitstring) {
		try {
			File file  = new File(filePath);
			//按行读取
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			
			List<Object[]> list = new ArrayList<Object[]>();
			while((str = br.readLine())!= null){
				String[] split = str.split(splitstring);
				list.add(split);
			}
			br.close();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/*
	 * 获取文件扩展名
	 */
	public static String getFileLastName(String path){
		File file = new File(path);
		String name = file.getName();
		return name.substring(name.indexOf("."));
	}
	

	/**
	 * 删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	 */
	public static void deleteFile(String path){
		File file = new File(path);
		
		if(file.isDirectory()){
			File[] listFiles = file.listFiles();
		
			for (File file2 : listFiles) {
				if(file2.isFile()){
					file2.delete();
				}else{
					deleteFile(file2.getPath());
				}
			}
		}else{
			file.delete();
		}
		//当里面所有东西都删除的时候，吧空文件夹删了   迭代删
		file.delete();
	}
	
	
	
	/**
	 * 获取操作系统用户目录
	 * @return
	 */
	public static String getSystemD(){
		String userHome = System.getProperty("user.home");
		return userHome;
	}
}
