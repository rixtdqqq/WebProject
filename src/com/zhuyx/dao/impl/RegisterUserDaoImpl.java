/**
 * 
 * ResigsterUser.java
 * Administrator
 * 2017年4月16日 上午10:02:32
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao.impl;

import java.sql.SQLException;

import com.zhuyx.dao.RegisterUserDao;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;
import com.zhuyx.util.JdbcUserUtil;

/**
 * @author Administrator 注册用户
 */
public class RegisterUserDaoImpl implements RegisterUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhuyx.dao.ResigsterUserDao#resigsterUser(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> resigsterUser(User user) {
		String createTime = user.getCreateTime();
		String userName = user.getUserName();
		String password = user.getPassword();
		String email = user.getEmail();
		String qq = user.getQq();
		String phone = user.getPhone();
		String weChat = user.getWeChat();
		String sql = "insert into User (userName,password,createTime,email,qq,phone,weChat) values (?,?,?,?,?,?,?)";
		JdbcUserUtil userUtil = null;
		try {
			userUtil = new JdbcUserUtil();
			userUtil.getConnection();
			boolean resigsterSuccess = userUtil.updateByPreparedStatement(sql, userName, password, createTime, email, qq, phone,
					weChat);
			if (resigsterSuccess) {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(1, "注册成功").build()).status(1)
						.message("成功有数据").build();
			} else {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(0, "注册失败").build()).status(1)
						.message("成功有数据").build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != userUtil) {
				userUtil.releaseConn();
			}
		}
		return new ResponseBody.Builder().status(99).message("异常").build();
	}

}
