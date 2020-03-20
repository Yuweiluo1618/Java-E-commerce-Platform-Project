package com.yuweiluo.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuweiluo.entity.LMONKEY_USER;
import com.yuweiluo.service.UserDAO;

/**
 * Servlet implementation class UsernameCheck
 */
@WebServlet("/usernamecheck")
public class UsernameCheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		int count = UserDAO.selectByName(name);
		
		PrintWriter out = response.getWriter();
		if(count > 0) {
			out.print("false");
		}else {
			out.print("true");
		}
		out.close();
	}

	

}
