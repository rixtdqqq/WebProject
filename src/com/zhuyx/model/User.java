/**
 * 
 * User.java
 * Administrator
 * 2017年4月16日 上午10:03:47
 * QQ : 2951589923
 * 
 */
package com.zhuyx.model;

/**
 * @author Administrator 用户实体
 */
public class User {

	private final int id;
	private final String userName;
	private final String password;
	private final String createTime;
	private final String qq;
	private final String weChat;
	private final String email;
	private final String phone;
	/**
	 * 验证码
	 */
	private final String checkCode;

	private User(Builder builder) {
		id = builder.id;
		userName = builder.userName;
		password = builder.password;
		createTime = builder.createTime;
		qq = builder.qq;
		weChat = builder.weChat;
		email = builder.email;
		phone = builder.phone;
		checkCode = builder.checkCode;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getCreateTime() {
		return createTime;
	}

	public String getQq() {
		return qq;
	}

	public String getWeChat() {
		return weChat;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public static class Builder {
		private int id;
		private String userName;
		private String password;
		private String createTime;
		private String qq;
		private String weChat;
		private String email;
		private String phone;
		private String checkCode;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder createTime(String createTime) {
			this.createTime = createTime;
			return this;
		}

		public Builder qq(String qq) {
			this.qq = qq;
			return this;
		}

		public Builder checkCode(String checkCode) {
			this.checkCode = checkCode;
			return this;
		}

		public Builder weChat(String weChat) {
			this.weChat = weChat;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", createTime=" + createTime
				+ ", qq=" + qq + ", weChat=" + weChat + ", email=" + email + ", phone=" + phone + ", checkCode="
				+ checkCode + "]";
	}
	
	

}
