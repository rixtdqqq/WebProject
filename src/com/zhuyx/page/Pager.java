/**
 * 
 * Pager.java
 * Administrator
 * 2017年4月14日 上午10:48:20
 * QQ : 2951589923
 * 
 */
package com.zhuyx.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 4516890623919664396L;
	/**
	 * 每页的条数
	 */
	private final int pageSize;
	/**
	 * 总页数
	 */
	private final int totalPage;
	/**
	 * 数据总数
	 */
	private final int totalRecord;
	/**
	 * 当前第几页
	 */
	private final int currentPage;

	private final List<T> data;

	private Pager(Builder<T> builder) {
		pageSize = builder.pageSize;
		totalPage = builder.totalPage;
		totalRecord = builder.totalRecord;
		currentPage = builder.currentPage;
		data = builder.data;
	}

	public int getPageSize() {
		return pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<T> getData() {
		return data;
	}

	public static class Builder<T> {

		private int pageSize;

		private int totalPage;

		private int totalRecord;

		private int currentPage;

		private List<T> data;
		
		public Builder(){}
		
		public Builder(int pageSize, int currentPage, List<T> data) {
			if (null == data || data.isEmpty())
				return;
			// 总记录条数
			this.pageSize = pageSize;
			totalRecord = data.size();
			// 总页数
			totalPage = totalRecord / pageSize;
			totalPage = totalRecord % pageSize == 0 ? totalPage : totalPage + 1;
			// 如果总页数只有3页，而传过来的是5页，就需要做如下判断
			this.currentPage = totalPage < currentPage ? totalPage : currentPage;
			// 起始索引
			int fromIndex = pageSize * (this.currentPage - 1);
			int toIndex = pageSize * this.currentPage > totalRecord ? totalRecord : pageSize * this.currentPage;
			this.data = data.subList(fromIndex, toIndex);
		}

		public Builder<T> pageSize(int pageSize) {
			this.pageSize = pageSize;
			return this;
		}

		public Builder<T> totalPage(int totalPage) {
			this.totalPage = totalPage;
			return this;
		}

		public Builder<T> totalRecord(int totalRecord) {
			this.totalRecord = totalRecord;
			return this;
		}

		public Builder<T> currentPage(int currentPage) {
			this.currentPage = currentPage;
			return this;
		}

		public Builder<T> data(List<T> data) {
			this.data = data;
			return this;
		}

		public Pager<T> build() {
			return new Pager<T>(this);
		}

	}
}
