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
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {
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
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		//Create User Object
		LMONKEY_USER u = new LMONKEY_USER(username,name,pwd,sex,year,null,email,mobile,address,1);
		
		//Add to Database
		int count = UserDAO.insert(u);
		
		//Result:(success or fail)
		if(count > 0) {
			response.sendRedirect("/E-commerceShop/manage/admin_douserselect");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('Register fail');");
			out.write("location.href='manage/admin_useradd.jsp';");
			out.write("</script>");
		}
				
	}

}
