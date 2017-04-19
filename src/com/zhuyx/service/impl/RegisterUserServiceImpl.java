/**
 * 
 * ResigsterUserServiceImpl.java
 * Administrator
 * 2017年4月16日 上午10:22:08
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service.impl;

import com.zhuyx.dao.RegisterUserDao;
import com.zhuyx.dao.impl.RegisterUserDaoImpl;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;
import com.zhuyx.service.RegisterUserService;

/**
 * @author Administrator
 *
 */
public class RegisterUserServiceImpl implements RegisterUserService {

	private RegisterUserDao userDao;

	public RegisterUserServiceImpl() {
		userDao = new RegisterUserDaoImpl();
	}

	@Override
	public ResponseBody<ResponseMessage> resigsterUser(User user) {
		return userDao.resigsterUser(user);
	}

}
