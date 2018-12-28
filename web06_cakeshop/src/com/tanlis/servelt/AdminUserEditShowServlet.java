package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.model.User;
import com.tanlis.service.UserService;

/**
 * Servlet implementation class AdminUserEditShowServlet
 */
@WebServlet("/admin/user_editshow")
public class AdminUserEditShowServlet extends HttpServlet {
	
	private UserService uService=new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		User user=uService.selectByID(id);
		request.setAttribute("u", user);
		request.getRequestDispatcher("/admin/user_edit.jsp").forward(request, response);
	}



}
