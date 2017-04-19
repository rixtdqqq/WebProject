/**
 * 
 * LoginServiceImpl.java
 * Administrator
 * 2017年4月16日 下午9:57:48
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service.impl;

import com.zhuyx.dao.LoginDao;
import com.zhuyx.dao.impl.LoginDaoImpl;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;
import com.zhuyx.service.LoginService;

/**
 * @author Administrator
 *
 */
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}

	/* (non-Javadoc)
	 * @see com.zhuyx.service.LoginService#login(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> login(User user) {
		return loginDao.login(user);
	}

}
