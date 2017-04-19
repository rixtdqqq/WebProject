package com.zhuyx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.User;
import com.zhuyx.service.CheckAccountAndEmailService;
import com.zhuyx.service.impl.CheckAccountAndEmailServiceImpl;

/**
 * Servlet implementation class CheckAccountAndEmailServlet
 */
@WebServlet("/CheckAccountAndEmailServlet")
public class CheckAccountAndEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckAccountAndEmailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//先从数据 库查找账号、邮箱
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String checkCode = request.getParameter("checkCode");
		if (null == checkCode) {
			checkCode = "";
		}
		User user = new User.Builder().userName(userName).email(email).checkCode(checkCode).build();
		CheckAccountAndEmailService service = new CheckAccountAndEmailServiceImpl();
		ResponseBody<ResponseMessage> responseBody = service.checkAccountAndEmail(user);
		request.setAttribute("result", new Gson().toJson(responseBody));
		System.out.println(new Gson().toJson(responseBody));
		request.getRequestDispatcher("demo.jsp").forward(request, response);
	}

}
