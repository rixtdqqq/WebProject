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
import com.zhuyx.service.FindPasswordService;
import com.zhuyx.service.impl.FindPasswordServiceImpl;
import com.zhuyx.util.SendEmailUtil;
import com.zhuyx.util.StringUtil;

/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/FindPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPasswordServlet() {
        super();
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
		String email = request.getParameter("email");
		if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(email)) {
			System.out.println("账号或邮箱为空！");
			return;
		}
		// 生成6位数字
		String checkCode = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
		User user = new User.Builder()
				.checkCode(checkCode)
				.userName(userName)
				.email(email)
				.build();
		FindPasswordService service = new FindPasswordServiceImpl();
		ResponseBody<ResponseMessage> findPassword = service.findPassword(user);
		SendEmailUtil util = new SendEmailUtil();
		util.doSendHtmlEmail("找回密码验证码", checkCode, email);
		Gson gson = new Gson();
		request.setAttribute("result", gson.toJson(findPassword));
		System.out.println(gson.toJson(findPassword));
		request.getRequestDispatcher("demo.jsp").forward(request, response);
		
	}

}
