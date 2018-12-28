package com.tanlis.servelt;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.model.Goods;
import com.tanlis.model.Order;
import com.tanlis.service.GoodsService;

/**
 * Servlet implementation class GoodsBuyServelt
 */
@WebServlet("/goods_buy")
public class GoodsBuyServelt extends HttpServlet {
    
	private GoodsService gService=new GoodsService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String, String[]> map=request.getParameterMap();
//		for(String key:map.keySet()) {
//			System.out.println(key+" "+map.keySet());
//		}
		
		Order o=null;
		if(request.getSession().getAttribute("order")!=null) {
			o=(Order)request.getSession().getAttribute("order");
		}else {
			o=new Order();
			request.getSession().setAttribute("order", o);
		}
		int goodsid=Integer.parseInt(request.getParameter("goodsid"));
		Goods goods=gService.getById(goodsid);
		if(goods.getStock()>0) {
			o.addGoods(goods);
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("fail");
		}
		//System.out.println(request.getParameter("goodsid"));
	}

}
