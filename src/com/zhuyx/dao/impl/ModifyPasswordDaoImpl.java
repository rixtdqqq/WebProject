/**
 * 
 * ModifyPasswordDaoImpl.java
 * Administrator
 * 2017年4月17日 下午8:16:28
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao.impl;

import com.zhuyx.dao.ModifyPasswordDao;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.User;
import com.zhuyx.util.JdbcUserUtil;

/**
 * @author Administrator
 *
 */
public class ModifyPasswordDaoImpl implements ModifyPasswordDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhuyx.dao.ModifyPasswordDao#modifyPassword(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> modifyPassword(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		String sql = "update User set password=? where 1=1 and userName=?";
		JdbcUserUtil util = null;
		try {
			util = new JdbcUserUtil();
			util.getConnection();
			boolean success = util.updateByPreparedStatement(sql, password, userName);
			if (success) {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(1, "密码修改成功，请用新密码登陆").build())
						.status(1).message("成功有数据").build();
			} else {
				return new ResponseBody.Builder().data(new ResponseMessage.Builder(0, "密码修改失败，请重新尝试").build()).status(1)
						.message("成功有数据").build();
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
