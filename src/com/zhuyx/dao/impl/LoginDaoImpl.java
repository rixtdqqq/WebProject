/**
 * 
 * LoginDaoImpl.java
 * Administrator
 * 2017年4月16日 下午9:56:30
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhuyx.dao.LoginDao;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;
import com.zhuyx.util.JdbcUserUtil;

/**
 * @author Administrator
 *
 */
public class LoginDaoImpl implements LoginDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhuyx.dao.LoginDao#login(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> login(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		String sql = "select * from User where 1=1 and userName=? and password=?";
		JdbcUserUtil util = null;
		try {
			List<Object> objects = new ArrayList<>();
			objects.add(userName);
			objects.add(password);
			util = new JdbcUserUtil();
			util.getConnection();
			boolean hasData = util.findResult(sql, objects);
			if (hasData) {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(1, "登录成功").build()).status(1)
						.message("成功有数据").build();
			} else {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(0, "用户名或密码错误").build()).status(1)
						.message("成功有数据").build();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (null != util) {
				util.releaseConn();
			}
		}
		return new ResponseBody.Builder().status(0).message("服务异常").build();
	}

}
