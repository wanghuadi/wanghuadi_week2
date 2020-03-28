package com.wanghuadi.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanghuadi.beans.Inspection;
import com.wanghuadi.beans.Status;
import com.wanghuadi.mapper.InspectionMapper;
import com.wanghuadi.utils.DateUtil;
import com.wanghuadi.utils.IOUtil;
import com.wanghuadi.utils.StringUtil;

public class TestIO {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		InspectionMapper bean = ac.getBean(InspectionMapper.class);
		
		List<Object[]> readFile = IOUtil.readFile("cms附件-机械设备公司年检信息.txt", "\t");
		int i = 1;
		for (Object[] objects : readFile) {
			Inspection is = new Inspection();
			/*
			 * 8.批量导入数据:将文本内容读入公司年检实体集合对象中,再读入SQL表中（21分）
			 */
//			主键  关键字   描述   公司名称  主营产品  地址 注册资本 成立时间  	xx  xx  年检状态
			String id = objects[0]+"";
			String keyword = objects[1]+"";
			String mes = objects[2]+"";
			String name = objects[3]+"";
			String product = objects[4]+"";
			String address = objects[5]+"";
			String capital = objects[6]+"";
			String idate = objects[7]+"";
			String status = objects[10]+"";
			//a.id值要使用isNumber()工具方法判断是不是数字（3分）
			if(i==1){
				id = id.substring(1);
			}
			i++;
			if(StringUtil.isNumber(id)){
				is.setId(new BigInteger(id));
			}
			//b. keywords	、description、公司名称、主营产品、地址要使用 hasText()方法判断有没有值。（3分）
			if(!StringUtil.isEmpty(keyword)){
				is.setKeyword(keyword);
			}
			if(!StringUtil.isEmpty(mes)){
				is.setMes(mes);
			}
			if(!StringUtil.isEmpty(name)){
				is.setName(name);
			}
			if(!StringUtil.isEmpty(product)){
				is.setProduct(product);
			}
			if(!StringUtil.isEmpty(address)){
				is.setAddress(address);
			}
			
			//c. 注册资本要使用hasText()方法判断有没有值，并使用 isNumber()判断是不是数字（3分）
			if(!StringUtil.isEmpty(capital)){
				if(StringUtil.isNumber(capital)){
					is.setCapital(Double.parseDouble(capital));
				}
			}
//			d.年检日期为null，在前端必须显示为空，不能显示null（3分）
//			c. 成立时间要使用hasText()方法判断有没有值,判断是不是日期类型（3分）
			if(!StringUtil.isEmpty(idate)){
				if(StringUtil.isDate(idate)){
					is.setIdate(DateUtil.stringToDate(idate));
				}
			}
//			Status.SUCCESS
//			is.setStatus(status.equals("未年检")?Status.WAIT:status == "通过"?Status.SUCCESS:Status.NOTSUCCESS);
//			d.将集合对象中每个年检对象通过MyBatis保存到数据库。总共316行，少一行扣2分，最多扣20分(6分)
			//添加数据库
			
			bean.insert(is);
		}
		
		

	}
}
