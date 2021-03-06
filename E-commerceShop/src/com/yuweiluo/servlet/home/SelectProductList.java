package com.yuweiluo.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yuweiluo.entity.LMONKEY_CATEGORY;
import com.yuweiluo.entity.LMONKEY_PRODUCT;
import com.yuweiluo.service.CategoryDAO;
import com.yuweiluo.service.ProductDAO;

/**
 * Servlet implementation class SelectProductList
 */
@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LMONKEY_CATEGORY> flist =  CategoryDAO.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<LMONKEY_CATEGORY> clist =  CategoryDAO.selectCat("child");
		request.setAttribute("clist", clist);
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		
		int id = 0;
		ArrayList<LMONKEY_PRODUCT> list = null;
		if(fid != null) {
			id = Integer.parseInt(fid);
			list = ProductDAO.selectAllByFid(id);
		}
		
		if(cid != null) {
			id = Integer.parseInt(cid);
			list = ProductDAO.selectAllByCid(id);
		}
		
		request.setAttribute("title", CategoryDAO.selectById(id).getCATE_NAME());
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}

}
