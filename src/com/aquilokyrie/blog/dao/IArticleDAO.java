package com.aquilokyrie.blog.dao;

import java.util.List;

import com.aquilokyrie.blog.vo.dto.ArticleDTO;
import com.aquilokyrie.blog.vo.dto.Page;
import com.aquilokyrie.blog.vo.entity.Article;

/**
 * 博文-数据访问接口
 * @author Chunping
 *
 */
public interface IArticleDAO {

	public Integer create(Article article);
	
	public Integer drop(Integer id);
	
	public Integer drop(List<Integer> ids);
	
	public Integer dropLogicle(Integer id);
	
	public Integer dropLogicle(List<Integer> id);
	
	public Article get(Integer id);
	
	public List<Article> getArticleList(ArticleDTO query);
	
	public Page<Article> getArticlePage(ArticleDTO query,Page<Article> page);
	
	public Integer modify(Article article);
	
	public Integer modifyCategory(Integer articleId,Integer categoryId);
	
	public Integer modifyCategory(List<Integer> articleIds,Integer categoryId);
	
	public Integer modifyTag(Integer articleId,Integer tagId);
	
	public Integer modifyTag(List<Integer> articleId,List<Integer> tagId);
}
