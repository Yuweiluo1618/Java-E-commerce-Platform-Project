package com.yuweiluo.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yuweiluo.service.UserDAO;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
	
		//Add to Database
		int count = UserDAO.del(id);
		//Result:(success or fail)
		if(count > 0) {
			response.sendRedirect("/E-commerceShop/manage/admin_douserselect?cp="+request.getParameter("cpage"));
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('Delete fail')");
			out.write("location.href='manage/admin_douserselecct?cp"+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String [] ids = request.getParameterValues("id[]");
	
		for(int i = 0; i < ids.length;i++) {
			String id = ids[i];
			UserDAO.del(id);
		}
		
	
		response.sendRedirect("/E-commerceShop/manage/admin_douserselect");
		
	}
}
