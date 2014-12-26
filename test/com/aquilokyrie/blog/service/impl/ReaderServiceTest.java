package com.aquilokyrie.blog.service.impl;

import com.aquilokyrie.blog.service.IReaderService;
import com.aquilokyrie.blog.service.ServiceException;
import com.aquilokyrie.blog.vo.entity.Article;
import com.aquilokyrie.blog.BeanFactory;

public class ReaderServiceTest {
	
	IReaderService readerService = (IReaderService) BeanFactory.getBean("readerService");
	
	public static void main(String[] args) {
		ReaderServiceTest test = new ReaderServiceTest();
		
		test.testRead();
	}
	
	public void testRead(){
		Article a = null;
		try {
			a = readerService.read(1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(a);
	} 

}
