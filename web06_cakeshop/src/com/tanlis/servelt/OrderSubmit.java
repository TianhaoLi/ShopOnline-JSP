package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderSubmit
 */
@WebServlet("/order_submit")
public class OrderSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("user")!=null) {
			request.getRequestDispatcher("/order_submit.jsp").forward(request, response);
		}else {
			request.setAttribute("failMsg", "请登陆后，再提交订单！");
			request.getRequestDispatcher("/user_login.jsp").forward(request, response);
		}
	}



}
