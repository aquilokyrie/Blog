package com.aquilokyrie.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.aquilokyrie.blog.util.log.Logger;

public class SessionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/blog";
	private static final String USER_NAME = "blog";
	private static final String PASSWORD = "0GsAaxjHnamFkY=TIOYsiA2rsQ4vSPzmAuvVygNtq3Nz6aurbM-f)v}hDbXtHA{v";
	
	private static Logger logger = Logger.getInstance(SessionFactory.class);
	
	private static Connection CON;
	static{
		try{
			Class.forName(DRIVER);		//加载数据库引擎，返回给定字符串名的类
			CON = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		} catch (ClassNotFoundException e){
			logger.err("没有找到指定名称的数据库驱动", e);
			System.exit(0);
		} catch (SQLException e) {
			logger.err("建立数据库连接失败", e);
			System.exit(0);
		}
	}
	
	public static Connection getSession(){
		return CON;
	}
	
	public static PreparedStatement createQuery(String sql){
		PreparedStatement result = null;
		
		try {
			result = CON.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			logger.err("创建Statement失败", e);
		}
		
		return result;
	}
	
	private SessionFactory(){
	}
	
}
