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

	/**
	 * 创建新文章到数据库
	 * @param article 新文章实体
	 * @return 新创建博文的编号
	 */
	public Integer create(Article article);
	
	/**
	 * 删除博文
	 * @param id 博文编号
	 * @return 该函数所影响的记录数
	 */
	public Integer drop(Integer id);
	
	/**
	 * 批量删除博文
	 * @param ids 待删除的博文编号列表
	 * @return 该函数所影响的记录数
	 */
	public Integer drop(List<Integer> ids);
	
	/**
	 * 逻辑删除博文
	 * @param id 博文编号
	 * @return 该函数所影响的记录数
	 */
	public Integer dropLogicle(Integer id);
	
	/**
	 * 批量逻辑删除博文
	 * @param ids 待删除的博文编号列表
	 * @return 该函数所影响的记录数
	 */
	public Integer dropLogicle(List<Integer> ids);
	
	/**
	 * 查询单个博文详情
	 * @param id 博文编号
	 * @return 查询出的博文实体,若没有和编号存在的博文则返回null
	 */
	public Article get(Integer id);
	
	public List<Article> getArticleList(ArticleDTO query);
	
	/**
	 * 查询博文分页对象
	 * @param query 查询条件
	 * @param page 分页对象,用于输入分页条件
	 * @return 已分页的博文列表
	 */
	public Page<Article> getArticlePage(ArticleDTO query,Page<Article> page);
	
	public Integer modify(Article article);
	
	public Integer modifyCategory(Integer articleId,Integer categoryId);
	
	public Integer modifyCategory(List<Integer> articleIds,Integer categoryId);
	
	public Integer modifyTag(Integer articleId,Integer tagId);
	
	public Integer modifyTag(List<Integer> articleId,List<Integer> tagId);
}
