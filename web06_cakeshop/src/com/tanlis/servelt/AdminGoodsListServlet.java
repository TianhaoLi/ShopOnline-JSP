package com.tanlis.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.model.Page;
import com.tanlis.model.Type;
import com.tanlis.service.GoodsService;

/**
 * Servlet implementation class AdminGoodsListServlet
 */
@WebServlet("/admin/goods_list")
public class AdminGoodsListServlet extends HttpServlet {

	private GoodsService gService=new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type=0;//推荐类型
		if(request.getParameter("type")!=null) {
			type=Integer.parseInt(request.getParameter("type"));
		}
		
		int pageNo=1;
		if(request.getParameter("pageNo")!=null) {
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		
//		List<Goods> list=gService.selectGoods(id, pageNo, 8);
//		request.setAttribute("list", list);
		
		Page p=gService.getGoodsRecommendPage(type, pageNo);
		request.setAttribute("p", p);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/admin/goods_list.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
