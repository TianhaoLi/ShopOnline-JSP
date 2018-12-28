package com.tanlis.servelt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tanlis.model.Type;
import com.tanlis.service.TypeService;
import com.tanlis.utils.DBUtil;

/**
 * Servlet implementation class AdminTypeEditServlet
 */
@WebServlet("/admin/type_edit")
public class AdminTypeEditServlet extends HttpServlet {
	
	private TypeService tService=new TypeService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Type t=new Type();
		try {
			BeanUtils.copyProperties(t, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(t.toString());
		tService.update(t);
		request.getRequestDispatcher("/admin/type_list").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
