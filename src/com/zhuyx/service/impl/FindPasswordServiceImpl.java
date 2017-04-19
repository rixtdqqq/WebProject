/**
 * 
 * FindPasswordServiceImpl.java
 * Administrator
 * 2017年4月17日 下午7:36:41
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service.impl;

import com.zhuyx.dao.FindPasswordDao;
import com.zhuyx.dao.impl.FindPasswordDaoImpl;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.User;
import com.zhuyx.service.FindPasswordService;

/**
 * @author Administrator
 *
 */
public class FindPasswordServiceImpl implements FindPasswordService {
	
	private FindPasswordDao dao;
	public FindPasswordServiceImpl() {
		dao = new FindPasswordDaoImpl();
	}

	/* (non-Javadoc)
	 * @see com.zhuyx.service.FindPasswordService#findPassword(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> findPassword(User user) {
		return dao.findPassword(user);
	}

}
