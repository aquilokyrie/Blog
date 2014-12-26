package com.aquilokyrie.blog.vo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示分页查询时分页风格的类
 * @author Chunping
 *
 * @param <T>
 */
public class Page<T> {
	
	private Integer currentPage;//当前页
	private Integer pageSize;//页大小
	private Integer recordTotal;//记录总数
	private Integer pageTotal;//总页数
	
	private List<Sort> sorts;//排序方式集合
	private List<T> resultList;//查询结果集
	
	/**
	 * 发起查询时创建Page对象的构造方法
	 * @param pageSize 页大小
	 * @param currentPage 当前页
	 * @param sorts 排序方式数组
	 */
	public Page(Integer pageSize,Integer currentPage,Sort ...sorts ){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		this.pageTotal = -1;
		this.recordTotal = -1;
		
		this.sorts = new ArrayList<Sort>(sorts.length);
		for(Sort sort : sorts){
			this.sorts.add(sort);
		}
	}
	
	/**
	 * 创建查询时使用的构造函数
	 * 设当前页为1,页面大小为20
	 * 
	 * @param sorts 排序规则
	 */
	public Page(Sort ...sorts){
		this(20, 1, sorts);
	}
	
	/**
	 * 返回查询结果时创建Page对象的构造方法
	 * @param currentPage 当前页页码
	 * @param recordTotal 总记录数
	 * @param result 查询结果集
	 */
	public Page(Integer pageSize,Integer currentPage,Integer recordTotal,List<T> result){
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.recordTotal = recordTotal;
		this.pageTotal = getPageTotal(this.pageSize,recordTotal);
		
		this.resultList = result;
	}
	
	/**
	 * 获取当前页页码
	 * @return
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * 获取该分页对象所代表的分页策咯中的页面大小
	 * 即每页有多少个记录数
	 * @return 该分页对象所代表的分页策咯中的页面大小,-1代表当前未须在意
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 获取结果集中的总记录数
	 * @return
	 */
	public Integer getRecordTotal() {
		return recordTotal;
	}

	/**
	 * 获取结果集中的总页数
	 * @return
	 */
	public Integer getPageTotal() {
		return pageTotal;
	}

	/**
	 * 获取查询结果集
	 * @return
	 */
	public List<T> getResultList() {
		return resultList;
	}
	
	/**
	 * 获取排序字符串
	 * @return 排序字符串,形如" fieldName desc,fieldName asc,... "
	 */
	public String getSortString(){
		StringBuilder result = new StringBuilder(' ');
		
		for(Sort item : this.sorts){
			result.append(item.toString()).append(',');
		}
		
		result.deleteCharAt(result.lastIndexOf(","));
		result.append(' ');
		
		return result.toString();
	}

	private static final Integer getPageTotal(Integer pageSize,Integer total){
		int pageT = total / pageSize;
		int pageZ = total % pageSize;
		if (pageZ != 0) {
			pageT = pageT + 1;
		}
		return pageT;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", recordTotal=" + recordTotal + ", pageTotal=" + pageTotal
				+ ", sorts=" + sorts + ", resultList=" + resultList + "]";
	}

}
