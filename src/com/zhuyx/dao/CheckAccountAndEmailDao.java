/**
 * 
 * FindPasswordDao.java
 * Administrator
 * 2017年4月17日 下午1:52:41
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao;

import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;

/**
 * @author Administrator
 *
 */
public interface CheckAccountAndEmailDao {

	/**
	 * 找回密码
	 * 2017年4月17日
	 * 上午10:19:06
	 * Administrator
	 */
	ResponseBody<ResponseMessage> checkAccountAndEmail(User user);
}
