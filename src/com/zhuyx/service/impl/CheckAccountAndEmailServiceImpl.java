/**
 * 
 * FindPasswordServiceImpl.java
 * Administrator
 * 2017年4月17日 下午1:55:29
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service.impl;

import com.zhuyx.dao.CheckAccountAndEmailDao;
import com.zhuyx.dao.impl.CheckAccountAndEmailDaoImpl;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;
import com.zhuyx.service.CheckAccountAndEmailService;

/**
 * @author Administrator
 *
 */
public class CheckAccountAndEmailServiceImpl implements CheckAccountAndEmailService {

	private CheckAccountAndEmailDao dao;
	public CheckAccountAndEmailServiceImpl() {
		dao = new CheckAccountAndEmailDaoImpl();
	}

	/* (non-Javadoc)
	 * @see com.zhuyx.service.FindPasswordService#findPassword(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> checkAccountAndEmail(User user) {
		return dao.checkAccountAndEmail(user);
	}

}
