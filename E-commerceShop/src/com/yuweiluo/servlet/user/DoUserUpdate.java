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
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("userName");
		String name = request.getParameter("Name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String userStatus = request.getParameter("userStatus");
		
		int status = 1;
		if(userStatus != null) {
			status = Integer.parseInt(userStatus);
		}
		//Create User Object
		LMONKEY_USER user = new LMONKEY_USER(username,name,pwd,sex,birthday,null,email,mobile,address,status);
		
		//Add to Database
		int count = UserDAO.update(user);
		//Result:(success or fail)
		if(count > 0) {
			response.sendRedirect("/E-commerceShop/manage/admin_douserselect?cp="+ request.getParameter("cpage"));
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('Modified fail')");
			out.write("location.href='manage/admin_touserupdate?id="+username+"'");
			out.write("</script>");
		}
	}

}
