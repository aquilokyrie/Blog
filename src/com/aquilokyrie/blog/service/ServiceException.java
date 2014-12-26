package com.aquilokyrie.blog.service;

/**
 * 业务层异常
 * @author Chunping
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1276822170861281157L;
	
	private Integer errorCode;//错误代号,0代表该异常未定义对应的错误代号
	private String alertMessage;
	private Exception event;
	
	public ServiceException(Integer errCode,String message,Exception e){
		this.errorCode = errCode;
		this.alertMessage = message;
		this.event = e;
	}
	
	public ServiceException(Integer code,String message){
		this(code,message,null);
	}
	
	public ServiceException(String message){
		this(0,message,null);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return alertMessage;
	}

	public Exception getEvent() {
		return event;
	}
	
	public String toString(){
		return "[" + this.errorCode + "]" + this.alertMessage; 
	}

}
