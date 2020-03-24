package com.yuweiluo.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.yuweiluo.entity.LMONKEY_USER;
import com.yuweiluo.service.UserDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("username");
		System.out.println(username);
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");

		// Create User Object
		LMONKEY_USER u = new LMONKEY_USER(username, name, pwd, sex, year, null, email, mobile, address, 1);

		// Add to Database
		int count = UserDAO.insert(u);
		
		// Result:(success or fail)
		if (count > 0) {
			response.sendRedirect("login.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('Register fail');");
			out.write("location.href='/E-commerceShop/reg.jsp';");
			out.write("</script>");
		}
	}

}
