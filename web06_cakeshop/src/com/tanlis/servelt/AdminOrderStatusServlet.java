package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.service.OrderService;

/**
 * Servlet implementation class AdminOrderStatusServlet
 */
@WebServlet("/admin/order_status")
public class AdminOrderStatusServlet extends HttpServlet {
	
	private OrderService o=new OrderService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		int status=Integer.parseInt(request.getParameter("status"));
		o.updateStatus(id, status);
		response.sendRedirect(request.getContextPath()+"/admin/order_list?status="+status);
	}


}
