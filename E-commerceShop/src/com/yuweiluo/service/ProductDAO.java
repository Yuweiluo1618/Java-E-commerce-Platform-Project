package com.yuweiluo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yuweiluo.dao.Basedao;
import com.yuweiluo.entity.LMONKEY_PRODUCT;

public class ProductDAO {

	// Insert new Product
	public static int insert(LMONKEY_PRODUCT p) {
		String sql = "insert into lmonkey_product values(null,?,?,?,?,?,?,?)";
		Object[] params = { p.getPRODUCT_NAME(), p.getPRODUCT_DESCRIPTION(), p.getPRODUCT_PRICE(), p.getPRODUCT_STOCK(),
				p.getPRODUCT_FID(), p.getPRODUCT_CID(), p.getPRODUCT_FILENAME() };
		return Basedao.exectuIUD(sql, params);
	}

	// obtain all Products
	public static ArrayList<LMONKEY_PRODUCT> selectAll() {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from lmonkey_product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(rs.getInt("PRODUCT_ID"), rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"), rs.getInt("PRODUCT_PRICE"), rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"), rs.getInt("PRODUCT_CID"), rs.getString("PRODUCT_FILENAME")

				);

				list.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return list;

	}

	// Query all Products by Fid
	public static ArrayList<LMONKEY_PRODUCT> selectAllByFid(int fid) {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from lmonkey_product where PRODUCT_FID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			while (rs.next()) {
				LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(rs.getInt("PRODUCT_ID"), rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"), rs.getInt("PRODUCT_PRICE"), rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"), rs.getInt("PRODUCT_CID"), rs.getString("PRODUCT_FILENAME")

				);

				list.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return list;

	}

	// Query all Products by Cid
	public static ArrayList<LMONKEY_PRODUCT> selectAllByCid(int cid) {
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from lmonkey_product where PRODUCT_CID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while (rs.next()) {
				LMONKEY_PRODUCT p = new LMONKEY_PRODUCT(rs.getInt("PRODUCT_ID"), rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"), rs.getInt("PRODUCT_PRICE"), rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"), rs.getInt("PRODUCT_CID"), rs.getString("PRODUCT_FILENAME")

				);

				list.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return list;

	}

	// Query product by ID
	public static LMONKEY_PRODUCT selectById(int id) {
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		LMONKEY_PRODUCT p = null;
		try {
			String sql = "select * from lmonkey_product where PRODUCT_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new LMONKEY_PRODUCT(rs.getInt("PRODUCT_ID"), rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"), rs.getInt("PRODUCT_PRICE"), rs.getInt("PRODUCT_STOCK"),
						rs.getInt("PRODUCT_FID"), rs.getInt("PRODUCT_CID"), rs.getString("PRODUCT_FILENAME")

				);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return p;

	}

}
