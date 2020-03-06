package com.yuweiluo.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuweiluo.entity.LMONKEY_USER;
import com.yuweiluo.service.UserDAO;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//current page
		int cpage = 1;
		//max record for every page
		int count = 5;
		//obtain user's page
		String cp = request.getParameter("cp");
		
		//receive keyword
		String keyWord = request.getParameter("keywords");
		
		if(cp != null) {
			cpage = Integer.parseInt(cp);
		}
		
		int[] arr = UserDAO.totalPage(count, keyWord);
		//obtain all users' information
		ArrayList<LMONKEY_USER> list = UserDAO.selectAll(cpage,count,keyWord);
		
		//put information in the request object
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if(keyWord != null) {
			request.setAttribute("searchParams","&keywords="+keyWord);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	}

	
}
