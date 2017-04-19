/**
 * 
 * FindPasswordDaoImpl.java
 * Administrator
 * 2017年4月17日 下午7:35:19
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhuyx.dao.FindPasswordDao;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.User;
import com.zhuyx.util.JdbcUserUtil;

/**
 * @author Administrator
 *
 */
public class FindPasswordDaoImpl implements FindPasswordDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhuyx.dao.FindPasswordDao#findPassword(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> findPassword(User user) {
		String checkCode = user.getCheckCode();
		String userName = user.getUserName();
		String email = user.getEmail();
		String sql = "update User set checkCode=? where 1=1 and userName=? and email=?";
		JdbcUserUtil util = null;
		try {
			util = new JdbcUserUtil();
			util.getConnection();
			boolean success = util.updateByPreparedStatement(sql, checkCode, userName, email);
			if (success) {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(1, "请移步邮箱获取验证码").build()).status(1)
						.message("成功有数据").build();
			} else {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(0, "验证码发送失败，请重新发送").build())
						.status(1).message("成功有数据").build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != util) {
				util.releaseConn();
			}
		}
		return new ResponseBody.Builder().status(99).message("服务异常").build();
	}

}
