/**
 * 
 * ResigsterUser.java
 * Administrator
 * 2017年4月16日 上午10:02:32
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao;

import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;

/**
 * @author Administrator
 *	注册用户
 */
public interface RegisterUserDao {
	/**
	 * 注册用户
	 * @return 是否注册成功
	 * 2017年4月16日
	 * 上午10:19:06
	 * Administrator
	 */
	ResponseBody<ResponseMessage> resigsterUser(User user);

}
