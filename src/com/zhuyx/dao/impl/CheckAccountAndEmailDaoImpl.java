/**
 * 
 * FindPasswordDaoImpl.java
 * Administrator
 * 2017年4月17日 下午1:54:00
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhuyx.dao.CheckAccountAndEmailDao;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;
import com.zhuyx.util.JdbcUserUtil;

/**
 * @author Administrator
 *
 */
public class CheckAccountAndEmailDaoImpl implements CheckAccountAndEmailDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhuyx.dao.FindPasswordDao#findPassword(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> checkAccountAndEmail(User user) {
		String userName = user.getUserName();
		String email = user.getEmail();
		String checkCode = user.getCheckCode();
		boolean hasCheckCode = !"".equals(checkCode);
		String sql = "select * from User where 1=1 and userName=? and email=?";
		if (hasCheckCode) {
			sql = "select * from User where 1=1 and userName=? and email=? and checkCode=?";
		}
		JdbcUserUtil util = null;
		try {
			List<String> params = new ArrayList<>();
			params.add(userName);
			params.add(email);
			if (hasCheckCode) {
				params.add(checkCode);
			}
			util = new JdbcUserUtil();
			util.getConnection();
			boolean hasResult = util.findResult(sql, params);
			if (!hasCheckCode) {
				if (hasResult) {
					return new ResponseBody.Builder().data(new ResponseMessage.Builder(1, "成功有数据").build()).status(1)
							.message("成功有数据").build();
				} else {
					return new ResponseBody.Builder().data(new ResponseMessage.Builder(0, "账号或邮箱错误").build()).status(1)
							.message("成功有数据").build();
				}
			} else{
				if (hasResult) {
					return new ResponseBody.Builder().data(new ResponseMessage.Builder(1, "成功有数据").build()).status(1)
							.message("成功有数据").build();
				} else {
					return new ResponseBody.Builder().data(new ResponseMessage.Builder(0, "验证码输入错误").build()).status(1)
							.message("成功有数据").build();
				}
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
