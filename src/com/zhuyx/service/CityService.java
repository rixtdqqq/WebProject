/**
 * 
 * CityService.java
 * Administrator
 * 2017年4月14日 下午12:16:09
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service;

import com.zhuyx.model.City;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.Pager;

/**
 * @author Administrator
 *
 */
public interface CityService {
	/**
	 * 查询城市信息
	 * 
	 * @param cityModel
	 *            封装的查询条件
	 * @param pageNum
	 *            查询第几页数据
	 * @param pageSize
	 *            每页显示多少条记录，默认为10
	 * @return 2017年4月14日 下午12:17:41 Administrator
	 */
	ResponseBody<Pager<City>> findCity(City cityModel, int pageNum, int pageSize);
}
