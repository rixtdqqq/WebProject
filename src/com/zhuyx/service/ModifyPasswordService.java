/**
 * 
 * ModifyPasswordService.java
 * Administrator
 * 2017年4月17日 下午8:14:38
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
public interface ModifyPasswordService {
	
	ResponseBody<ResponseMessage> modifyPassword(User user);

}
