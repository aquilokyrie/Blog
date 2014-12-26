package com.aquilokyrie.blog.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aquilokyrie.blog.dao.IArticleDAO;
import com.aquilokyrie.blog.dao.SessionFactory;
import com.aquilokyrie.blog.util.log.Logger;
import com.aquilokyrie.blog.vo.dto.ArticleDTO;
import com.aquilokyrie.blog.vo.dto.Page;
import com.aquilokyrie.blog.vo.entity.Article;
import com.aquilokyrie.blog.vo.entity.ArticleCategory;
import com.aquilokyrie.blog.vo.entity.User;

/**
 * 博文数据访问对象-使用string拼接sql字符串,并使用JDBC的实现类
 * @author Chunping
 *
 */
public class ArticleDAOStringImpl implements IArticleDAO {
	
	private static Logger logger = Logger.getInstance(SessionFactory.class);

	@Override
	public Integer create(Article article) {
		if(article == null)
			return 0;
		
		StringBuilder sql = new StringBuilder("insert into t_blog_article(title,content,category_id,create_user_id,create_date)values(");
		
		sql.append("'").append(article.getTitle()).append("'").append(",");
		sql.append("'").append(article.getContent()).append("'").append(",");
		sql.append(article.getCategory().getId()).append(",");
		sql.append(article.getWriter().getId()).append(",");
		sql.append("now()");
		
		sql.append(")");
		
		try {
			PreparedStatement q = SessionFactory.createQuery(sql.toString());
			q.executeUpdate();
			
			ResultSet rs = q.getGeneratedKeys();
			if (rs != null && rs.next()) {  
				article.setId(rs.getInt(1)); 
			} 
		} catch (SQLException e) {
			logger.err("sql语句执行失败", e);
		}
		
		return article.getId();
	}

	@Override
	public Integer drop(Integer id) {
		if(!this.checkId(id))
			return 0;
		
		String sql = "delete from t_blog_article where id = ?";
		
		int result = 0;
		try {
			PreparedStatement query = SessionFactory.createQuery(sql);
			query.setInt(1, id);
			
			result = query.executeUpdate();
		} catch (SQLException e) {
			logger.err("删除时创建查询失败", e);
			return 0;
		}
		return result;
	}

	@Override
	public Integer drop(List<Integer> ids) {
		if(!this.checkIdList(ids))
			return 0;
		
		String sql = "delete from t_blog_article where id in ( " +listToStringParam(ids)+ " )";
		
		int result = 0;
		try {
			PreparedStatement query = SessionFactory.createQuery(sql);
			result = query.executeUpdate();
		} catch (SQLException e) {
			logger.err("删除时创建查询失败", e);
			return 0;
		}
		return result;
	}
	
	/**
	 * 将List转换为形为"aaa,bbb,ccc,...,nnn"的字符串
	 * @param list
	 * @return
	 */
	private String listToStringParam(List<? extends Object> list){
		String result = list.toString();
		
		return result.replace('[', ' ').replace(']', ' ');
	}

	@Override
	public Integer dropLogicle(Integer id) {
		if(!this.checkId(id))
			return 0;
		
		String sql = "update t_blog_article set is_deleted = 1 where id = ?";
		
		int result = 0;
		try {
			PreparedStatement query = SessionFactory.createQuery(sql);
			query.setInt(1, id);
			
			result = query.executeUpdate();
		} catch (SQLException e) {
			logger.err("博文假删失败", e);
		}
		return result;
	}
	
	/**
	 * 检查实体的id是否符合逻辑
	 * @param id 检验对象
	 * @return 是否符合逻辑
	 */
	private boolean checkId(Integer id){
		return id != null && id > 0;
	}

	/**
	 * 检查实体的id是否符合逻辑
	 * @param ids 检验对象
	 * @return 是否符合逻辑
	 */
	@Override
	public Integer dropLogicle(List<Integer> ids) {
		if(!this.checkIdList(ids))
			return 0;
		
		String sql = "update t_blog_article set is_deleted = 1 where id in (" + listToStringParam(ids) + ")";
		
		int result = 0;
		try {
			PreparedStatement query = SessionFactory.createQuery(sql);
			
			result = query.executeUpdate();
		} catch (SQLException e) {
			logger.err("博文假删失败", e);
		}
		return result;
	}
	
	private boolean checkIdList(List<Integer> ids){
		if(ids == null || ids.isEmpty())
			return false;
		
		for(int i : ids){
			if(i <= 0)
				return false;
		}
		
		return true;
	}

	@Override
	public Article get(Integer id) {
		Article result = new Article();
		String sql = "select a.id as a_id,a.title,a.content,a.create_date as a_date,c.id as c_id,c.name,u.id as u_id,u.email "
				+ "from t_blog_article as a , t_blog_category as c,t_blog_user as u "
				+ "where a.category_id = c.id and a.create_user_id = u.id and a.id = ?";
		
		PreparedStatement query = SessionFactory.createQuery(sql);
		try {
			query.setInt(1, id);
			
			ResultSet rs = query.executeQuery();
			while(rs.next()){
				result = getArticleFromRs(rs);
			}
		} catch (SQLException e) {
			logger.err("查询单个文章时失败", e);
		}
		return result;
	}
	
	private Article getArticleFromRs(ResultSet rs){
		Article result = new Article();
		
		try {
			result.setId(rs.getInt("a_id"));
			result.setTitle(rs.getString("title"));
			result.setContent(rs.getString("content"));
			result.setCreateDate(rs.getTimestamp("a_date"));
			
			result.setCategory(new ArticleCategory(rs.getInt("c_id")));
			result.getCategory().setName(rs.getString("name"));
			
			result.setWriter(new User(rs.getInt("u_id")));
			result.getWriter().setEmail(rs.getString("email"));
		} catch (SQLException e) {
			logger.err("从结果集中创建Article失败", e);
		}
		
		return result;
	}

	@Override
	public List<Article> getArticleList(ArticleDTO query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<Article> getArticlePage(ArticleDTO param,Page<Article> page) {
		
		StringBuilder sql = new StringBuilder("select a.ID as a_id,a.TITLE,a.CONTENT,a.CREATE_DATE as a_date,u.id as u_id,u.email,c.id as c_id,c.name");
		sql.append(" from t_blog_article as a,t_blog_category as c,t_blog_user as u ");
		sql.append(" where a.CATEGORY_ID = c.id and a.CREATE_USER_ID = u.id and a.is_deleted <> 1");
		sql.append(" order by ").append(page.getSortString());
		sql.append(' ').append(" limit ").append((page.getCurrentPage() - 1) * page.getPageSize()).append(',').append(page.getPageSize());
		
		StringBuilder countSql = new StringBuilder("select count(*)");
		countSql.append(" from t_blog_article as a,t_blog_category as c,t_blog_user as u ");
		countSql.append(" where a.CATEGORY_ID = c.id and a.CREATE_USER_ID = u.id and a.is_deleted <> 1");
		
		List<Article> resultList = new ArrayList<Article>();
		int total = 0;
		try {
			PreparedStatement query = SessionFactory.createQuery(countSql.toString());
			ResultSet rs = query.executeQuery();
			rs.next();
			total = rs.getInt(1);
			
			query = SessionFactory.createQuery(sql.toString());
			rs = query.executeQuery();
			while(rs.next()){
				resultList.add( this.getArticleFromRs(rs) );
			}
		} catch (SQLException e) {
			logger.err("查询博文Page失败", e);
		}
		
		Page<Article> result = new Page<Article>(page.getPageSize(),page.getCurrentPage(), total, resultList);
		return result;
	}

	@Override
	public Integer modify(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modifyCategory(Integer articleId, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modifyCategory(List<Integer> articleIds, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modifyTag(Integer articleId, Integer tagId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modifyTag(List<Integer> articleId, List<Integer> tagId) {
		// TODO Auto-generated method stub
		return null;
	}

}
