package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.service.OrderService;

/**
 * Servlet implementation class AdminOrderDeleteServlet
 */
@WebServlet("/admin/order_delete")
public class AdminOrderDeleteServlet extends HttpServlet {

	private OrderService o=new OrderService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		o.delete(id);
		request.getRequestDispatcher("/admin/order_list").forward(request, response);;
	}



}
