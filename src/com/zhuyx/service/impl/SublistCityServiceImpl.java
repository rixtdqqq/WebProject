/**
 * 
 * CityServiceImpl.java
 * Administrator
 * 2017年4月14日 下午12:46:57
 * QQ : 2951589923
 * 
 */
package com.zhuyx.service.impl;

import com.zhuyx.dao.CityDao;
import com.zhuyx.dao.impl.SublistCityDaoImpl;
import com.zhuyx.model.City;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.Pager;
import com.zhuyx.service.CityService;

/**
 * @author Administrator
 *
 */
public class SublistCityServiceImpl implements CityService {
	
	private CityDao cityDao;
	public SublistCityServiceImpl() {
		cityDao = new SublistCityDaoImpl();
	}

	/* (non-Javadoc)
	 * @see com.zhuyx.service.CityService#findCity(com.zhuyx.model.City, int, int)
	 */
	@Override
	public ResponseBody<Pager<City>> findCity(City cityModel, int pageNum, int pageSize) {
		return cityDao.findCity(cityModel, pageNum, pageSize);
	}

}
