package com.yuweiluo.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuweiluo.entity.LMONKEY_CART;
import com.yuweiluo.entity.LMONKEY_PRODUCT;
import com.yuweiluo.entity.LMONKEY_USER;
import com.yuweiluo.service.CartDao;
import com.yuweiluo.service.ProductDAO;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LMONKEY_PRODUCT p = null;
		
		String pid = request.getParameter("id");
		String count = request.getParameter("count");
		String url = request.getParameter("url");
		
		HttpSession session = request.getSession();
		String isLogin = (String) session.getAttribute("isLogin");
		LMONKEY_USER user = (LMONKEY_USER) session.getAttribute("name");
		
		if(user != null && isLogin.equals("1")) {
			String uid = user.getUSER_ID();
			if(pid != null) {
				p = ProductDAO.selectById(Integer.parseInt(pid));
			}
			LMONKEY_CART cart = new LMONKEY_CART(
					0,
					p.getPRODUCT_FILENAME(),
					p.getPRODUCT_NAME(),
					p.getPRODUCT_PRICE(),
					Integer.parseInt(count),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_ID(),
					uid,
					1
			);
			
			CartDao.insert(cart);
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('Please Login !');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
	}


}
