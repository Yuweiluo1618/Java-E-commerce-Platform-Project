package com.yuweiluo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yuweiluo.dao.Basedao;
import com.yuweiluo.entity.LMONKEY_CART;
import com.yuweiluo.entity.LMONKEY_PRODUCT;
import com.yuweiluo.entity.LMONKEY_USER;

public class CartDao {
	
	//Add cart to the database
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
	
	//query all the cart for owner 
	public static ArrayList<LMONKEY_CART> getCart(String id) {
		ArrayList<LMONKEY_CART> list = new ArrayList<LMONKEY_CART>();
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from lmonkey_cart where cart_u_id = ? and cart_valid = 1  order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				LMONKEY_CART c = new LMONKEY_CART(
						rs.getInt("cart_id"), 
						rs.getString("cart_p_filename"),
						rs.getString("cart_p_name"), 
						rs.getInt("cart_p_price"), 
						rs.getInt("cart_quantity"),
						rs.getInt("cart_p_stock"), 
						rs.getInt("cart_p_id"), 
						rs.getString("cart_u_id"),
						rs.getInt("cart_valid")

				);

				list.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return list;

	}
	
	public static LMONKEY_CART getCartShop(String uid, String pid) {
		LMONKEY_CART es = null;
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from lmonkey_cart where cart_u_id = ? and cart_p_id = ? and cart_valid = 1  order by cart_id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(pid));
			rs = ps.executeQuery();
			while (rs.next()) {
				es = new LMONKEY_CART(
						rs.getInt("cart_id"), 
						rs.getString("cart_p_filename"),
						rs.getString("cart_p_name"), 
						rs.getInt("cart_p_price"), 
						rs.getInt("cart_quantity"),
						rs.getInt("cart_p_stock"), 
						rs.getInt("cart_p_id"), 
						rs.getString("cart_u_id"),
						rs.getInt("cart_valid")

				);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return es;
	}
	
	public static int updatenum(int esid, int count) {
		String sql = "update lmonkey_cart set cart_quantity = ?  where cart_id = ?";
		
		Object[] params = {count,esid};
		
		return Basedao.exectuIUD(sql, params);
	}

	
}
