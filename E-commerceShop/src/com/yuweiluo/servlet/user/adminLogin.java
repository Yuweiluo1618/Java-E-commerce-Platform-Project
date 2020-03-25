package com.yuweiluo.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuweiluo.entity.LMONKEY_USER;
import com.yuweiluo.service.UserDAO;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/manage/adminlogin")
public class adminLogin extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		int count = UserDAO.selectByNM(username, password);
		if (count > 0) {
			LMONKEY_USER user = UserDAO.selectAdmin(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			if (user.getUSER_STATUS() == 2) {
				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("/E-commerceShop/manage/admin_index.jsp");
			} else {
				response.sendRedirect("/E-commerceShop/index.jsp");

			}
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('User Login Fail');");
			out.write("location.href='/E-commerceShop/manage/login.jsp';");
			out.write("</script>");
		}

	}

}
