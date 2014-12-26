package com.aquilokyrie.blog.vo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 博客文章实体
 * @author Chunping
 *
 */
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3683998909465568137L;
	
	private Integer id;
	private String title;
	private String content;
	private Date createDate;
	private User writer;
	private Integer isDeleted;
	
	private ArticleCategory category;
	private Set<ArticleTag> tags;
	
	public Article(){
		super();
	}
	
	public Article(String title,String content,Integer categoryId,Integer writerId){
		this.title = title;
		this.content = content;
		
		this.category = new ArticleCategory(categoryId);
		this.writer = new User(writerId);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public ArticleCategory getCategory() {
		return category;
	}

	public void setCategory(ArticleCategory category) {
		this.category = category;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Set<ArticleTag> getTags() {
		return tags;
	}

	public void setTags(Set<ArticleTag> tags) {
		this.tags = tags;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer is_deleted) {
		this.isDeleted = is_deleted;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", createDate=" + createDate + ", category="
				+ category + ", writer=" + writer + ", tags=" + tags + "]";
	}

}
