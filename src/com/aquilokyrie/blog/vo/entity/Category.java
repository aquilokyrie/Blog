package com.aquilokyrie.blog.vo.entity;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1998548275479686516L;
	
	private Integer id;
	private String name;
	private Category parent;
	
	public Category(){
		super();
	}
	
	public Category(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Category getParent() {
		return parent;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "ArticleCategory [id=" + id + ", name=" + name + ", parent="
				+ parent + "]";
	}
}
