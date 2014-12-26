package com.aquilokyrie.blog.util.log;

public class Logger {
	
	private Logger(){
	}
	
	public static Logger getInstance(Class<?> c){
		return new Logger();
	}
	
	public void info(String message){
		System.out.println(message);
	}
	
	public void info(Integer message){
		System.out.println(message);
	}
	
	public void info(Object o){
		System.out.println(o.toString());
	}
	
	public void err(String message){
		
	}
	
	public void err(String message,Exception e){
		System.out.println(message);
		
		e.printStackTrace();
	}
}
