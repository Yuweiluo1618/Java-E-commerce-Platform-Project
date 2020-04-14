package com.yuweiluo.service;

import com.yuweiluo.dao.Basedao;
import com.yuweiluo.entity.LMONKEY_CART;

public class CartDao {
	public static int insert(LMONKEY_CART cart) {
		String sql = "insert into lmonkey_cart values(null,?,?,?,?,?,?,?,1)";
		
		Object[] params = {
				cart.getCart_p_filename(),
				cart.getCart_p_name(),
				cart.getCart_p_price(),
				cart.getCart_quantity(),
				cart.getCart_p_stock(),
				cart.getCart_p_id(),
				cart.getCart_u_id()
		};
		
		return Basedao.exectuIUD(sql, params);
		
	}
}
