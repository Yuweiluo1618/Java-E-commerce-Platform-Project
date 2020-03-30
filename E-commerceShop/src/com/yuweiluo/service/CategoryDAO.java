package com.yuweiluo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yuweiluo.dao.Basedao;
import com.yuweiluo.entity.LMONKEY_CATEGORY;


/*
 * obtain all the category
 */
public class CategoryDAO {
	
	//obtain all categories
	public static ArrayList<LMONKEY_CATEGORY> selectAll() {
		ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from lmonkey_category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY
						(rs.getInt("CATE_ID"), 
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_NAME"));

				list.add(cate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return list;

	}
	
	//obtain sub-category from front-end
	public static ArrayList<LMONKEY_CATEGORY> selectCat(String flag) {
		ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = null;
			if(flag != null && flag.equals("father")) {
				sql = "select * from lmonkey_category where CATE_PARENT_NAME = 0";
			}else {
				sql = "select * from lmonkey_category where CATE_PARENT_NAME != 0";
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				LMONKEY_CATEGORY cate = new LMONKEY_CATEGORY
						(rs.getInt("CATE_ID"), 
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_NAME"));

				list.add(cate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return list;

	}
	
	// Insert new category
	public static int insert(LMONKEY_CATEGORY cate) {
		String sql = "insert into lmonkey_category values(null,?,?)";
		Object[] params = {cate.getCATE_NAME(), cate.getCATE_PARENT_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	
	
	// query category by ID
	public static LMONKEY_CATEGORY selectById(int id) {
		LMONKEY_CATEGORY cate = null;
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select * from lmonkey_category  where CATE_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cate = new LMONKEY_CATEGORY(rs.getInt("CATE_ID"), 
											rs.getString("CATE_NAME"), 
											rs.getInt("CATE_PARENT_NAME"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return cate;

	}
	
	//update category
	public static int update(LMONKEY_CATEGORY cate) {
		String sql = "update lmonkey_category set CATE_NAME = ?, CATE_PARENT_NAME = ? where CATE_ID = ?";
		Object[] params = { cate.getCATE_NAME(), 
							cate.getCATE_PARENT_ID(),
							cate.getCATE_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int del(int id) {
		String sql = "delete from LMONKEY_CATEGORY where CATE_ID = ?";
		Object[] params = {id};
		return Basedao.exectuIUD(sql, params);
		
	}
}
