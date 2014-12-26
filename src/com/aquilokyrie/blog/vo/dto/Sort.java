package com.aquilokyrie.blog.vo.dto;

public class Sort {
	
	public enum OrderStyle {
		ASC, // 升序
		DESC // 降序
	}
	
	private String field;
	private OrderStyle style;

	private Sort(String field, OrderStyle style) {
		this.field = field;
		this.style = style;
	}

	/**
	 * 创建升序对象
	 * @param field 需要升序排序的字段名
 	 * @return
	 */
	public static Sort asc(String field) {
		return new Sort(field, OrderStyle.ASC);
	}

	/**
	 * 创建降序排序对象
	 * @param field 需要降序排序的字段名
	 * @return
	 */
	public static Sort desc(String field) {
		return new Sort(field, OrderStyle.DESC);
	}

	/**
	 * 本条件是否为升序
	 * 
	 * @return 是否为升序
	 */
	public boolean isAsc() {
		return OrderStyle.ASC.equals(this.style);
	}

	@Override
	public String toString() {
		return new StringBuilder(this.field).append(' ').append(this.style)
				.toString();
	}

	@Override
	public int hashCode() {
		int result = 1;
		result *= this.getField().hashCode();
		result *= this.style.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		// obj's type is correct and is not null
		if (!(obj instanceof Sort))
			return false;
		Sort s = (Sort) obj;
		return s.style == this.style
				&& (s.getField() == null ? false : s.getField().equals(
						this.field));
	}

	public String getField() {
		return field;
	}

	public OrderStyle getStyle() {
		return style;
	}

}
