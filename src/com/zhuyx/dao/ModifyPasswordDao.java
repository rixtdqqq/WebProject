/**
 * 
 * ModifyPasswordDao.java
 * Administrator
 * 2017年4月17日 下午8:15:46
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
public interface ModifyPasswordDao {

	ResponseBody<ResponseMessage> modifyPassword(User user);
}
