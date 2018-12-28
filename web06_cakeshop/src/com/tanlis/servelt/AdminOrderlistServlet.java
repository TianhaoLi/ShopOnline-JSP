package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.model.Page;
import com.tanlis.service.OrderService;

/**
 * Servlet implementation class AdminOrderlistServlet
 */
@WebServlet("/admin/order_list")
public class AdminOrderlistServlet extends HttpServlet {
	private OrderService o=new OrderService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//结合前台订单查询
		int status=0;
		if(request.getParameter("status")!=null) {
			status=Integer.parseInt(request.getParameter("status"));
		}
		request.setAttribute("status", status);
		int pageNo=1;
		if(request.getParameter("pageNo")!=null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		Page p=o.getOrderPage(status,pageNo);
		request.setAttribute("p",p);
		//System.out.println(p.getList().toString());
		request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
	}

}
