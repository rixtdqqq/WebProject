/**
 * 
 * CityDaoImpl.java
 * Administrator
 * 2017年4月14日 下午12:21:07
 * QQ : 2951589923
 * 
 */
package com.zhuyx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zhuyx.dao.CityDao;
import com.zhuyx.model.City;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.Pager;
import com.zhuyx.util.JdbcUtil;

/**
 * 使用sublist方式实现
 */
public class SublistCityDaoImpl implements CityDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhuyx.dao.CityDao#findCity(com.zhuyx.model.City, int, int)
	 */
	@Override
	public ResponseBody<Pager<City>> findCity(City cityModel, int pageNum, int pageSize) {
		List<City> cities = getAllCities(cityModel);
		if (null == cities) {
			return new ResponseBody.Builder().message("异常").status(99).build();
		} else if (null != cities && cities.isEmpty()) {
			return new ResponseBody.Builder().message("无数据").status(0).build();
		} else if (null != cities && !cities.isEmpty()) {
			return new ResponseBody.Builder().message("成功有数据").status(1)
					.data(new Pager.Builder(pageSize, pageNum, cities).build()).build();
		}
		return null;
	}

	private List<City> getAllCities(City cityModel) {
		List<City> result = new ArrayList<>();
		List<Object> objects = new ArrayList<>();
		String countryCode = cityModel.getCountryCode();
		String name = cityModel.getName();
		String district = cityModel.getDistrict();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM city WHERE 1=1 ");
		if (null != countryCode && !"".equals(countryCode)) {
			builder.append(" and CountryCode like ? ");
			objects.add("%" + countryCode + "%");
		}
		if (null != district && !"".equals(district)) {
			builder.append(" and District like ? ");
			objects.add("%" + district + "%");
		}
		if (null != name && !"".equals(name)) {
			builder.append(" and Name like ? ");
			objects.add("%" + name + "%");
		}

		JdbcUtil util = null;
		City city = null;
		try {
			util = new JdbcUtil();
			util.getConnection();
			List<Map<String, Object>> findResult = util.findResult(builder.toString(), objects);
			if (null != findResult && !findResult.isEmpty()) {
				for (Map<String, Object> map : findResult) {
					city = new City.Builder().name((String) map.get("Name"))
							.countryCode((String) map.get("CountryCode")).district((String) map.get("District"))
							.id((Integer) map.get("ID")).population((Integer) map.get("Population")).build();
					result.add(city);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据异常", e);
		} finally {
			if (null != util)
				util.releaseConn();
		}
		return result;
	}
}
