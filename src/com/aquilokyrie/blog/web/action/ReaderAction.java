package com.aquilokyrie.blog.web.action;

import java.util.ArrayList;
import java.util.List;

import com.aquilokyrie.blog.BeanFactory;
import com.aquilokyrie.blog.service.IReaderService;
import com.aquilokyrie.blog.service.IStatisticsService;
import com.aquilokyrie.blog.service.ServiceException;
import com.aquilokyrie.blog.vo.dto.ArticleDTO;
import com.aquilokyrie.blog.vo.dto.CategoryDTO;
import com.aquilokyrie.blog.vo.dto.Page;
import com.aquilokyrie.blog.vo.dto.Sort;
import com.aquilokyrie.blog.vo.entity.Article;

/**
 * 读者行为Action
 * @author Chunping
 *
 */
public class ReaderAction {
	
	private IReaderService readerService = (IReaderService) BeanFactory.getBean("readerService");
	private IStatisticsService statisticsService = (IStatisticsService) BeanFactory.getBean("statisticsService");
	
	private List<Article> leftArticleList;
	private List<Article> rightArticleList;
	private List<CategoryDTO> categoryList;
	
	private ArticleDTO articleQuery;
	
	
	public void articleStream(){
		Page<Article> page = new Page<Article>(Sort.desc("a.create_date"));
		
		Page<Article> articlePage = null;
		try {
			articlePage = this.readerService.getArticlePage(articleQuery, page);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leftArticleList = new ArrayList<Article>(articlePage.getResultList().size()/2);
		rightArticleList = new ArrayList<Article>(articlePage.getResultList().size()/2);
		
		for (Article article : articlePage.getResultList()) {
			if(leftArticleList.size() != rightArticleList.size())
				rightArticleList.add(article);
			else
				leftArticleList.add(article);
		}
		
		this.getCountedCategory();
	}
	
	public void getCountedCategory(){
		this.categoryList = this.statisticsService.queryCategoryWithArticleCount();
	}

	public IReaderService getReaderService() {
		return readerService;
	}

	public void setReaderService(IReaderService readerService) {
		this.readerService = readerService;
	}

	public ArticleDTO getArticleQuery() {
		return articleQuery;
	}

	public void setArticleQuery(ArticleDTO articleQuery) {
		this.articleQuery = articleQuery;
	}

	public List<Article> getLeftArticleList() {
		return leftArticleList;
	}

	public void setLeftArticleList(List<Article> leftArticleList) {
		this.leftArticleList = leftArticleList;
	}

	public List<Article> getRightArticleList() {
		return rightArticleList;
	}

	public void setRightArticleList(List<Article> rightArticleList) {
		this.rightArticleList = rightArticleList;
	}

	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}

}
