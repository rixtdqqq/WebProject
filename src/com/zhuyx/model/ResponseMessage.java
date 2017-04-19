/**
 * 
 * ResigsterStatus.java
 * Administrator
 * 2017年4月16日 上午10:40:11
 * QQ : 2951589923
 * 
 */
package com.zhuyx.model;

/**
 * @author Administrator
 * 注册状态
 */
public class ResponseMessage {

	/**
	 * 注册是否成功的状态
	 */
	private final int status;
	/**
	 * 注册是否成功的信息
	 */
	private final String message;
	
	private ResponseMessage(Builder builder){
		status = builder.status;
		message = builder.message;
	}
	
	public static class Builder{
		private int status;
		private String message;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}
		public Builder(int status,String message){
			this.status = status;
			this.message = message;
		}
		
		public ResponseMessage build(){
			return new ResponseMessage(this);
		}
	}
}
