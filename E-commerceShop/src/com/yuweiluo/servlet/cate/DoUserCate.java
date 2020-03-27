package com.yuweiluo.servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuweiluo.entity.LMONKEY_CATEGORY;
import com.yuweiluo.service.CategoryDAO;

/**
 * Servlet implementation class DoUserCate
 */
@WebServlet("/manage/admin_dousercate")
public class DoUserCate extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int fid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("className");
		
		LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY(0,name,fid);
		CategoryDAO.insert(cate);
		response.sendRedirect("admin_cateselect");
	
	}

}
