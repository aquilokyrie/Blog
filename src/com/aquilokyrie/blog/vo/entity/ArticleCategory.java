package com.aquilokyrie.blog.vo.entity;

import java.io.Serializable;

public class ArticleCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1998548275479686516L;
	
	private Integer id;
	private String name;
	private ArticleCategory parent;
	
	public ArticleCategory(){
		super();
	}
	
	public ArticleCategory(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArticleCategory getParent() {
		return parent;
	}
	public void setParent(ArticleCategory parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "ArticleCategory [id=" + id + ", name=" + name + ", parent="
				+ parent + "]";
	}
}
