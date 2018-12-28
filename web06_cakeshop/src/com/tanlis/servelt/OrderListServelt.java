package com.tanlis.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.model.Order;
import com.tanlis.model.User;
import com.tanlis.service.OrderService;

/**
 * Servlet implementation class OrderListServelt
 */
@WebServlet("/order_list")
public class OrderListServelt extends HttpServlet {

	private OrderService oService=new OrderService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=(User)request.getSession().getAttribute("user");
		List<Order> list=oService.selectAll(u.getId());
		request.setAttribute("orderlist", list);
		request.getRequestDispatcher("/order_list.jsp").forward(request, response);
	}

}
