/**
 * 
 * FindPasswordService.java
 * Administrator
 * 2017年4月17日 下午1:54:29
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
public interface CheckAccountAndEmailService {
	/**
	 * 找回密码
	 * @param user
	 * @return
	 * 2017年4月17日
	 * 下午1:54:58
	 * Administrator
	 */
	ResponseBody<ResponseMessage> checkAccountAndEmail(User user);
}
