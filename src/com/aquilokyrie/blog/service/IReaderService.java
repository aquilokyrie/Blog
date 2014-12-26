package com.aquilokyrie.blog.service;

import com.aquilokyrie.blog.vo.dto.ArticleDTO;
import com.aquilokyrie.blog.vo.dto.Page;
import com.aquilokyrie.blog.vo.entity.Article;

/**
 * 博客的阅读者业务逻辑接口
 * @author Chunping
 *
 */
public interface IReaderService {
	
	/**
	 * 读者阅读单个博文
	 * @param articleId 博文编号
	 * @return 博文实体,包括博文/博文所属类别/博文的标签集合
	 * @throws ServiceException 输入的博文编号不存在对应数据
	 */
	public Article read(Integer articleId) throws ServiceException;
	
	/**
	 * 读者查询博文列表
	 * @param param 查询条件
	 * @param page 分页和排序信息
	 * @return 符合查询条件的博文分页对象
	 * @throws ServiceException 输入的查询条件无法查询到任何文章或分页信息不合理
	 */
	public Page<Article> getArticlePage(ArticleDTO param,Page<Article> page) throws ServiceException;
}
