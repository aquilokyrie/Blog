package com.aquilokyrie.blog.web.tag;

import javax.servlet.jsp.tagext.TagData;  
import javax.servlet.jsp.tagext.TagExtraInfo;  
import javax.servlet.jsp.tagext.VariableInfo; 

/**
 * 标签变量的处理类  
 * @author Chunping
 *
 */
public class IteratorTagExtraInfo extends TagExtraInfo {  
	
    @Override  
    public VariableInfo[] getVariableInfo(TagData data) {  
          
        return new VariableInfo[] {new VariableInfo(data.getId(),  
                "com.aquilokyrie.blog.vo.entity.Article",true,VariableInfo.NESTED)};  
          
    }  
}  