/**
 * 
 * ModifyPasswordServiceImpl.java
 * Administrator
 * 2017年4月17日 下午8:15:24
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service.impl;

import com.zhuyx.dao.ModifyPasswordDao;
import com.zhuyx.dao.impl.ModifyPasswordDaoImpl;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.User;
import com.zhuyx.service.ModifyPasswordService;

/**
 * @author Administrator
 *
 */
public class ModifyPasswordServiceImpl implements ModifyPasswordService {
	
	private ModifyPasswordDao dao;
	public ModifyPasswordServiceImpl() {
		dao = new ModifyPasswordDaoImpl();
	}

	/* (non-Javadoc)
	 * @see com.zhuyx.service.ModifyPasswordService#modifyPassword(com.zhuyx.model.User)
	 */
	@Override
	public ResponseBody<ResponseMessage> modifyPassword(User user) {
		return dao.modifyPassword(user);
	}

}
