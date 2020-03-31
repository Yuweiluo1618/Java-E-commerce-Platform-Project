package com.yuweiluo.service;

import com.yuweiluo.dao.Basedao;
import com.yuweiluo.entity.LMONKEY_PRODUCT;


public class ProductDAO {
	
	// Insert new Product
		public static int insert(LMONKEY_PRODUCT p) {
			String sql = "insert into lmonkey_product values(null,?,?,?,?,?,?,?)";
			Object[] params = {
					p.getPRODUCT_NAME(), 
					p.getPRODUCT_DESCRIPTION(),
					p.getPRODUCT_PRICE(),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_FID(),
					p.getPRODUCT_CID(),
					p.getPRODUCT_FILENAME()
					};
			return Basedao.exectuIUD(sql, params);
		}

}
