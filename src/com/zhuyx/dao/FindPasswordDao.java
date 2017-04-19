/**
 * 
 * FindPasswordDao.java
 * Administrator
 * 2017年4月17日 下午7:33:55
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao;

import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.User;

/**
 * @author Administrator
 *
 */
public interface FindPasswordDao {
	/**
	 * 找回密码
	 * @param user
	 * @return 2017年4月17日 下午7:34:34 Administrator
	 */
	ResponseBody<ResponseMessage> findPassword(User user);
}
