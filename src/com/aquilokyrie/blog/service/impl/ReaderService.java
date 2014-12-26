package com.aquilokyrie.blog.service.impl;

import com.aquilokyrie.blog.BeanFactory;
import com.aquilokyrie.blog.dao.IArticleDAO;
import com.aquilokyrie.blog.service.IReaderService;
import com.aquilokyrie.blog.service.ServiceException;
import com.aquilokyrie.blog.util.log.Logger;
import com.aquilokyrie.blog.vo.dto.ArticleDTO;
import com.aquilokyrie.blog.vo.dto.Page;
import com.aquilokyrie.blog.vo.entity.Article;

/**
 * 读者业务逻辑实现类
 * @author Chunping
 *
 */
public class ReaderService implements IReaderService {
	
	private Logger logger = Logger.getInstance(ReaderService.class);
	
	private IArticleDAO articleDAO = (IArticleDAO)BeanFactory.getBean("articleDAO");

	@Override
	public Article read(Integer articleId) throws ServiceException {
		Article result;
		
		try {
			result = this.articleDAO.get(articleId);
		} catch (Exception e) {
			logger.err("读者Service,read方法发生错误", e);
			throw new ServiceException(1, "服务器发生系统错误,您可以联络博主以帮助解决此问题");
		}
		
		if(result == null || (result.getIsDeleted() != null && result.getIsDeleted() == 1)){
			throw new ServiceException(2, "该文章不存在");
		}
		return result;
	}

	@Override
	public Page<Article> getArticlePage(ArticleDTO param, Page<Article> page)
			throws ServiceException {
		Page<Article> result;
		try {
			result = this.articleDAO.getArticlePage(param, page);
		} catch (Exception e) {
			logger.err("读者Service.getArticlePage方法发生错误", e);
			throw new ServiceException(1, "服务器发生系统错误,您可以联络博主以帮助解决此问题");
		}
		
		if(result == null || result.getPageTotal() == 0 || result.getResultList().isEmpty() ){
			throw new ServiceException(3, "该检索条件下没有查询结果");
		}
		return result;
	}

}
