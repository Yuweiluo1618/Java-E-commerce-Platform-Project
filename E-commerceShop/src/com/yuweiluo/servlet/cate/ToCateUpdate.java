package com.yuweiluo.servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuweiluo.entity.LMONKEY_CATEGORY;
import com.yuweiluo.service.CategoryDAO;

/**
 * Servlet implementation class ToCateUpdate
 */
@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		LMONKEY_CATEGORY cate = CategoryDAO.selectById(id);
		
		ArrayList<LMONKEY_CATEGORY> catelist = CategoryDAO.selectAll();
		request.setAttribute("catelist", catelist);
		request.setAttribute("cate1", cate);
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}


}
