/**
 * 
 * ResponseBody.java
 * Administrator
 * 2017年4月15日 下午6:31:54
 * QQ : 2951589923
 * 
 */
package com.zhuyx.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class ResponseBody<T> implements Serializable {

	private static final long serialVersionUID = 3878191192521888481L;
	/**
	 * 状态码 1：成功 0：无数据 99：异常
	 */
	private final int status;
	private final String message;
	private final T data;
	
	

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	private ResponseBody(Builder<T> builder) {
		status = builder.status;
		message = builder.message;
		data = (T) builder.data;
	}

	public static class Builder<T> {
		private int status;
		private String message;
		private T data;

		public Builder<T> status(int status) {
			this.status = status;
			return this;
		}

		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}

		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}

		public ResponseBody<T> build() {
			return new ResponseBody<T>(this);
		}
	}

}
