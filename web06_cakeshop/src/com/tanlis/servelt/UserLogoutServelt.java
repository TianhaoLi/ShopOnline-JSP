package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogoutServelt
 */
@WebServlet("/user_logout")
public class UserLogoutServelt extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath()+'/');//重定向 到首页
	}


}
