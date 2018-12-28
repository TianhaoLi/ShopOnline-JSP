package com.tanlis.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanlis.model.Type;
import com.tanlis.service.TypeService;

/**
 * Servlet implementation class AdminTypeListServlet
 */
@WebServlet("/admin/type_list")
public class AdminTypeListServlet extends HttpServlet {
	
	private TypeService t=new TypeService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Type> list=t.selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("/admin/type_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
