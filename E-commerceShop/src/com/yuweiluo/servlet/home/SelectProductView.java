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
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LMONKEY_CATEGORY> flist =  CategoryDAO.selectCat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<LMONKEY_CATEGORY> clist =  CategoryDAO.selectCat("child");
		request.setAttribute("clist", clist);
		
		String id = request.getParameter("id");
		
		LMONKEY_PRODUCT p = null;
		
		if(id != null) {
			p = ProductDAO.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		
		if(p!= null) {
			int cid = p.getPRODUCT_CID();
			ArrayList<LMONKEY_PRODUCT> classlist = ProductDAO.selectAllByCid(cid);
			request.setAttribute("classlist", classlist);
		}
		
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}

	

}
