package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.model.Order;

/**
 * Servlet implementation class GoodsLessonServelt
 */
@WebServlet("/goods_lesson")
public class GoodsLessonServelt extends HttpServlet {
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Order o=(Order)request.getSession().getAttribute("order");
		int goodsid=Integer.parseInt(request.getParameter("goodsid"));
		o.lessen(goodsid);
		response.getWriter().print("ok");
	}

}
