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
import com.zhuyx.service.ModifyPasswordService;
import com.zhuyx.service.impl.ModifyPasswordServiceImpl;

/**
 * Servlet implementation class ModifyPasswordServlet
 */
@WebServlet("/ModifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPasswordServlet() {
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
		ModifyPasswordService service = new ModifyPasswordServiceImpl();
		ResponseBody<ResponseMessage> modifyPassword = service.modifyPassword(user);
		Gson gson = new Gson();
		request.setAttribute("result", gson.toJson(modifyPassword));
		System.out.println(gson.toJson(modifyPassword));
		request.getRequestDispatcher("demo.jsp").forward(request, response);
		
	}
}
