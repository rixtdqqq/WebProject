/**
 * 
 * CityService.java
 * Administrator
 * 2017年4月14日 下午12:16:09
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service;

import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;

/**
 * @author Administrator
 * 注册用户的服务
 */
public interface RegisterUserService {
	/**
	 * 注册用户
	 * @return 是否注册成功
	 * 2017年4月16日
	 * 上午10:19:06
	 * Administrator
	 */
	ResponseBody<ResponseMessage> resigsterUser(User user);
}
