package com.aquilokyrie.blog.vo.entity;

public class User {
	
	private Integer id;
	private String email;
	
	public User(){
		super();
	}
	
	public User(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String name) {
		this.email = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + "]";
	}

}
