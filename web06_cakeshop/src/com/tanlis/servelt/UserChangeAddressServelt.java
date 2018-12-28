package com.tanlis.servelt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jdt.internal.compiler.batch.Main;

import com.tanlis.model.User;
import com.tanlis.service.UserService;

/**
 * Servlet implementation class UserChangeAddressServelt
 */
@WebServlet("/user_changeaddress")
public class UserChangeAddressServelt extends HttpServlet {

	private UserService uService =new UserService();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User loginUser=(User)request.getSession().getAttribute("user");
		try {
			request.setCharacterEncoding("utf-8");
			BeanUtils.copyProperties(loginUser, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uService.updateUserAddress(loginUser);
		request.setAttribute("msg", "收件信息,更新成功！");
		request.getRequestDispatcher("/user_center.jsp").forward(request, response);
	}


}
