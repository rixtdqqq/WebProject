package com.zhuyx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zhuyx.model.City;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.Pager;
import com.zhuyx.service.CityService;
import com.zhuyx.service.impl.SublistCityServiceImpl;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityService cityService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CityServlet() {
		super();
		cityService = new SublistCityServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		// 接收request里面的参数
		String name = request.getParameter("Name");
		if (null == name || "".equals(name)) {
			name = "";
		}
		String countryCode = request.getParameter("CountryCode");
		if (null == countryCode || "".equals(countryCode)) {
			countryCode = "";
		}
		String district = request.getParameter("District");
		if (null == district || "".equals(district)) {
			district = "";
		}
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize;
		if (null == pageSizeStr || "".equals(pageSizeStr)) {
			pageSize = 10;
		} else {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = 0;
		if(null == pageNumStr||"".equals(pageNumStr)){
			pageNum = 1;
		}else{
			pageNum = Integer.parseInt(pageNumStr);
		}

		// 组装查询条件
		City city = new City.Builder().countryCode(countryCode).district(district).name(name).build();
		// 调用service获取查询结果
		ResponseBody<Pager<City>> result = cityService.findCity(city, pageNum, pageSize);
		// 返回结果到页面
		Gson gson = new Gson();
		request.setAttribute("result", gson.toJson(result));
		System.out.println(gson.toJson(result));
		request.getRequestDispatcher("demo.jsp").forward(request, response);
	}

}
