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
import com.zhuyx.service.LoginService;
import com.zhuyx.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 123456L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User.Builder()
				.userName(userName)
				.password(password)
				.build();
		LoginService loginService = new LoginServiceImpl();
		ResponseBody<ResponseMessage> responseBody = loginService.login(user);
		Gson gson = new Gson();
		request.setAttribute("result", gson.toJson(responseBody));
		System.out.println(gson.toJson(responseBody));
		request.getRequestDispatcher("demo.jsp").forward(request, response);
	}

}
