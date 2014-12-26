package com.aquilokyrie.blog.web.tag;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.aquilokyrie.blog.util.StringUtil;
import com.aquilokyrie.blog.util.log.Logger;

/**
 * value标签支持类,在jsp页面上输出name所指定的属性
 * @author Chunping
 *
 */
public class ValueTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 575669648324261076L;
	private Logger logger = Logger.getInstance(ValueTag.class);
	
	private static final Map<String,Integer> scopeMap = new Hashtable<String,Integer>(4);
	static{
		scopeMap.put("page", PageContext.PAGE_SCOPE);
		scopeMap.put("request", PageContext.REQUEST_SCOPE);
		scopeMap.put("session", PageContext.SESSION_SCOPE);
		scopeMap.put("application", PageContext.APPLICATION_SCOPE);
	}
	
	private String name;
	private String scope;
	
	public int doStartTag() throws JspException {
		scope = StringUtil.isBlank(scope) ? "request" : scope;
		Object toWrite = super.pageContext.getAttribute(name,scopeMap.get(scope));
		
		try {
			toWrite = toWrite == null ? "null" : toWrite;

			JspWriter out = super.pageContext.getOut();
			out.write(toWrite.toString());
		} catch (IOException e) {
			logger.err("value标签打印出错", e);
			throw new JspException();
		}
		
		return TagSupport.SKIP_PAGE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
