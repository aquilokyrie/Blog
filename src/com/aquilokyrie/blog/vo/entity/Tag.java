package com.aquilokyrie.blog.vo.entity;

import java.io.Serializable;

public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7923336554443401659L;

	private Integer id;
	private String name;
	private Tag parent;
	
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
	public Tag getParent() {
		return parent;
	}
	public void setParent(Tag parent) {
		this.parent = parent;
	}
}
