package com.aquilokyrie.blog.web.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.aquilokyrie.blog.util.StringUtil;
//import com.aquilokyrie.blog.util.log.Logger;

/**
 * 迭代器标签,用于遍历集合
 * @author Chunping
 *
 */
public class IteratorTag extends SimpleTagSupport {

	private static final Map<String,Integer> scopeMap = new Hashtable<String,Integer>(4);
	static{
		scopeMap.put("page", PageContext.PAGE_SCOPE);
		scopeMap.put("request", PageContext.REQUEST_SCOPE);
		scopeMap.put("session", PageContext.SESSION_SCOPE);
		scopeMap.put("application", PageContext.APPLICATION_SCOPE);
	}
	
	private String collection;//待遍历的集合名
	private String itemId;//遍历时的名称
	private String scope;//拉取集合时的查找范围
	
	/**
	 * 获取待遍历对象并初始化迭代器
	 * 将集合内成员压入page范围内
	 * @throws IOException 
	 */
	public void doTag() throws JspException, IOException {
		scope = StringUtil.isBlank(scope) ? "request" : scope;
		Object toTraversal = super.getJspContext().getAttribute(collection,scopeMap.get(scope));
		
		if(toTraversal != null ){
			for(Object item : (Collection<?>)toTraversal){
				super.getJspContext().setAttribute(itemId, item);
				
				super.getJspBody().invoke(null);
			}
		} 
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
