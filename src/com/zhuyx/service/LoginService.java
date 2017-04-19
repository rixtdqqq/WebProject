/**
 * 
 * LoginService.java
 * Administrator
 * 2017年4月16日 下午9:57:00
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service;

import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;

/**
 * @author Administrator
 *
 */
public interface LoginService {
	/**
	 * 登录
	 * 2017年4月16日
	 * 上午10:19:06
	 * Administrator
	 */
	ResponseBody<ResponseMessage> login(User user);
}
