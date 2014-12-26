package com.aquilokyrie.blog.web.filter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.aquilokyrie.blog.BeanFactory;
import com.aquilokyrie.blog.web.action.ReaderAction;

public class BlogFilter implements Filter {
	
	private ReaderAction readerAction;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		String uri = request.getRequestURI();
		
		try {
			Class<ReaderAction> readerClass = ReaderAction.class;
			Method method;

			if(uri.equals("/Blog/article_stream")){
				method = readerClass.getDeclaredMethod("articleStream");
				method.invoke(this.readerAction);
				
				setResult(readerClass,request);
				
				request.getRequestDispatcher("/jsp/blog/article_stream.jsp")
					.forward(arg0,arg1);
			}
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	/**
	 * 将action类的属性成员压入request域
	 * 该Action类必须为所有属性成员设置无参getter方法
	 * 
	 * @param actionClass action类对象
	 * @param request request对象
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void setResult(Class<?> actionClass,HttpServletRequest request) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		for(Method item :actionClass.getDeclaredMethods() ){
			if(item.getName().startsWith("get")){
				request.setAttribute(item.getName().replaceAll("get", ""),
						item.invoke(readerAction));
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.readerAction = (ReaderAction) BeanFactory.getBean("readerAction");
	}

}
