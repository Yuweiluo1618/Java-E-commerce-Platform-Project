package com.yuweiluo.servlet.product;

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
 * Servlet implementation class ToProductAdd
 */
@WebServlet("/manage/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LMONKEY_CATEGORY> flist =  CategoryDAO.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<LMONKEY_CATEGORY> clist =  CategoryDAO.selectCat("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);
	}


}
