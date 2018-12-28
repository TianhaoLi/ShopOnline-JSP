package com.tanlis.servelt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tanlis.model.User;
import com.tanlis.service.UserService;

/**
 * Servlet implementation class UserRegisterServelt
 */
@WebServlet("/user_register")
public class UserRegisterServelt extends HttpServlet {
	private UserService uService=new UserService();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username=request.getParameter("username");
//		String email=request.getParameter("email");
//		String password=request.getParameter("password");
//		String name=request.getParameter("name");
//		String phone=request.getParameter("phone");
//		String address=request.getParameter("address");
		User user=new User();
		try {
			BeanUtils.copyProperties(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uService.register(user)) {
		request.setAttribute("msg", "注册成功,请登录！");
		request.getRequestDispatcher("user_login.jsp").forward(request, response);
	}else {
		request.setAttribute("msg", "用户名或邮箱重复,请重新注册");
		request.getRequestDispatcher("user_register.jsp").forward(request, response);
	}
	}
}
