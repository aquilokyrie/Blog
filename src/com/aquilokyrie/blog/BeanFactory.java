package com.aquilokyrie.blog;

import java.lang.reflect.Field;

import com.aquilokyrie.blog.dao.impl.ArticleDAOStringImpl;
import com.aquilokyrie.blog.service.impl.ReaderService;
import com.aquilokyrie.blog.web.action.ReaderAction;

public class BeanFactory {
	
	@SuppressWarnings("unused")
	private static final ArticleDAOStringImpl ARTICLEDAO = new ArticleDAOStringImpl();
	@SuppressWarnings("unused")
	private static final ReaderService READERSERVICE = new ReaderService();
	@SuppressWarnings("unused")
	private static final ReaderAction READERACTION = new ReaderAction();

	public static Object getBean(String name){
		Class<BeanFactory> factory = BeanFactory.class;
		
		try {
			Field[] fields = factory.getDeclaredFields();
			for(Field item : fields){
				if(item.getName().equalsIgnoreCase(name)){
					return item.get(null);
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
