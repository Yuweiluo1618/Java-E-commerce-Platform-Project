package com.yuweiluo.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuweiluo.entity.LMONKEY_USER;
import com.yuweiluo.service.UserDAO;



/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		LMONKEY_USER user = UserDAO.selectByID(id);
		
		request.setAttribute("user", user);
		request.setAttribute("cpage", request.getParameter("cpage"));
		
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
	}

}
