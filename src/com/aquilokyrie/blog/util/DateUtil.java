package com.aquilokyrie.blog.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 提供日期处理所使用的工具类
 * 
 * 该类不能创建实例，仅作为工具使用
 * 
 * @author Chunping
 *
 */
public class DateUtil {
	
	private static final DateFormat DATE_DF = new SimpleDateFormat("yyyy-MM-dd"); 
	private static final DateFormat DATE_TIME_DF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
	
	private DateUtil(){
	}
	
	public static String getNow(){
		return DATE_TIME_DF.format(new Date());
	}
	
	public static String getToday(){
		return DATE_DF.format(new Date());
	}
}
