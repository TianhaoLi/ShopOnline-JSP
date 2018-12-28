package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.security.auth.NTDomainPrincipal;
import com.tanlis.model.Goods;
import com.tanlis.service.GoodsService;

/**
 * Servlet implementation class GoodsDetailServelt
 */
@WebServlet("/goods_detail")
public class GoodsDetailServelt extends HttpServlet { 
	
	private GoodsService gService=new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Goods g=gService.getById(id);
		request.setAttribute("g", g);
		request.getRequestDispatcher("/goods_detail.jsp").forward(request, response);
	}


}
