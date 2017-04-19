/**
 * 
 * FindPasswordService.java
 * Administrator
 * 2017年4月17日 下午7:35:43
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service;

import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.User;

/**
 * @author Administrator
 *
 */
public interface FindPasswordService {
	/**
	 * 找回密码
	 * 
	 * @param user
	 * @return 2017年4月17日 下午7:36:12 Administrator
	 */
	ResponseBody<ResponseMessage> findPassword(User user);
}
