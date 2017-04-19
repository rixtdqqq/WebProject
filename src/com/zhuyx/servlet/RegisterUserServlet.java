package com.zhuyx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zhuyx.model.ResponseMessage;
import com.zhuyx.model.ResponseBody;
import com.zhuyx.model.User;
import com.zhuyx.service.RegisterUserService;
import com.zhuyx.service.impl.RegisterUserServiceImpl;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
		String createTime = request.getParameter("createTime");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		String weChat = request.getParameter("weChat");
		String phone = request.getParameter("phone");
		User user = new User.Builder()
				.userName(userName)
				.password(password)
				.createTime(createTime)
				.qq(qq)
				.email(email)
				.weChat(weChat)
				.phone(phone)
				.build();
		RegisterUserService userService = new RegisterUserServiceImpl();
		ResponseBody<ResponseMessage> resigsterUser = userService.resigsterUser(user);
		Gson gson = new Gson();
		request.setAttribute("result",gson.toJson(resigsterUser));
		request.getRequestDispatcher("demo.jsp").forward(request, response);
	}
	

}
