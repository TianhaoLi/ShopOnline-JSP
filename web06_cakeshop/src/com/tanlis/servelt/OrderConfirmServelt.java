package com.tanlis.servelt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tanlis.model.Order;
import com.tanlis.model.User;
import com.tanlis.service.OrderService;

/**
 * Servlet implementation class OrderConfirmServelt
 */
@WebServlet("/order_confirm")
public class OrderConfirmServelt extends HttpServlet {
	
	private OrderService oService=new OrderService(); 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order o =(Order)request.getSession().getAttribute("order");
		try {
			//request.setCharacterEncoding("utf-8");  改用filter过滤 编码
			BeanUtils.copyProperties(o, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.setDatetime(new Date());
		o.setStatus(2);
		o.setUser((User) request.getSession().getAttribute("user"));
		oService.addOrder(o);
		request.getSession().removeAttribute("order");
		
		request.setAttribute("msg", "订单支付成功！ ");
		request.getRequestDispatcher("/order_success.jsp").forward(request, response);
	}

}
