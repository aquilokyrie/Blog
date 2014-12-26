package com.aquilokyrie.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.aquilokyrie.blog.dao.IArticleDAO;
import com.aquilokyrie.blog.dao.impl.ArticleDAOStringImpl;
import com.aquilokyrie.blog.util.log.Logger;
import com.aquilokyrie.blog.vo.dto.ArticleDTO;
import com.aquilokyrie.blog.vo.dto.Page;
import com.aquilokyrie.blog.vo.dto.Sort;
import com.aquilokyrie.blog.vo.entity.Article;

public class ArticleDAOStringImplTest {
	
	private IArticleDAO articleDAO = new ArticleDAOStringImpl();
	private Logger logger = Logger.getInstance(ArticleDAOStringImplTest.class);
	
	public static void main(String[] args) {
		ArticleDAOStringImplTest test = new ArticleDAOStringImplTest();
		
//		test.testCreate();
//		test.testDrop();
//		test.testGet();
//		test.testDropList();
//		test.testDropLogical();
//		test.testDropLogicalList();
		test.testGetArticlePage();
	}

	public void testCreate(){
		Article article = new Article("测试title", "测试正文", 1, 1);
		
		Integer newId = this.articleDAO.create(article);
		logger.info(newId);
	}
	
	public void testDrop(){
		this.articleDAO.drop(3);
	}
	
	public void testDropList(){
		List<Integer> list = new ArrayList<Integer>(2);
		list.add(4);
		list.add(5);
		list.add(6);
		
		this.articleDAO.drop(list);
	}
	
	public void testDropLogical(){
		this.articleDAO.dropLogicle(1);
	}
	
	public void testDropLogicalList(){
		List<Integer> list = new ArrayList<Integer>(2);
		list.add(1);
		list.add(2);
		
		this.articleDAO.dropLogicle(list);
	}
	
	public void testGet(){
		Article article = this.articleDAO.get(4);
		
		logger.info(article);
	}
	
	public void testGetArticlePage(){
		Page<Article> page = new Page<Article>(2,1,new Sort[]{Sort.desc("a.create_date")});
		
		page = this.articleDAO.getArticlePage(new ArticleDTO(), page);
		System.out.println(page);
	}
	
}
