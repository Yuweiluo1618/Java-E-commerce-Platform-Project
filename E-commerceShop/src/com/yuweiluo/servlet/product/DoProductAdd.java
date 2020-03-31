package com.yuweiluo.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yuweiluo.entity.LMONKEY_PRODUCT;
import com.yuweiluo.service.ProductDAO;

/**
 * Servlet implementation class DoProductAdd
 */
@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create SmartUpload Object
		SmartUpload su = new SmartUpload();
		
		//init
		su.initialize(this.getServletConfig(), request, response);
		
		//update 
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//obtain upload object
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		
		//obtain the file name
		String fname = f.getFileName();
		
		//save the file
		try {
			su.save("images/product");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Request req1 = su.getRequest();
		String pname = req1.getParameter("productName");
		String id = req1.getParameter("parentId");
		String price = req1.getParameter("productPrice");
		String desc = req1.getParameter("productDesc");
		String stock = req1.getParameter("productStock");
		
		//Create Java Bean
		LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(
				0,
				pname,
				desc,
				Integer.parseInt(price),
				Integer.parseInt(stock),
				Integer.parseInt(id.split("-")[0]),
				Integer.parseInt(id.split("-")[1]),
				fname
				);
		
		int count = ProductDAO.insert(p);
		
		if(count > 0) {
			response.sendRedirect("/E-commerceShop/manage/admin_productselect");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('Product Add fail');");
			out.write("location.href='manage/admin_toproductadd';");
			out.write("</script>");
		}
	}

}
