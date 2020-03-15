package com.yuweiluo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yuweiluo.dao.Basedao;
import com.yuweiluo.entity.LMONKEY_USER;

public class UserDAO {

	// add user
	public static int insert(LMONKEY_USER u) {
		String sql = "insert into lmonkey_user values(?,?,?,?,DATE_FORMAT(?,'%y-%m-%d'),?,?,?,?,?)";
		Object[] params = { u.getUSER_ID(), u.getUSER_NAME(), u.getUSER_PASSWOR(), u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(), u.getUSER_IDENITY_CODE(), u.getUSER_EMAIL(), u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(), u.getUSER_STATUS() };
		return Basedao.exectuIUD(sql, params);
	}

	// query user information
	public static ArrayList<LMONKEY_USER> selectAll(int cpage, int count, String keyword) {
		ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "";

			if (keyword != null) {

				sql = "select * from lmonkey_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
				ps.setInt(2, (cpage - 1) * count);
				ps.setInt(3, count);

			} else {
				sql = "select * from lmonkey_user order by USER_BIRTHDAY desc limit ?, ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, (cpage - 1) * count);
				ps.setInt(2, count);
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				LMONKEY_USER u = new LMONKEY_USER(rs.getString("USER_ID"), rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"), rs.getString("USER_SEX"), rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"), rs.getString("USER_EMAIL"), rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"), rs.getInt("USER_STATUS"));

				list.add(u);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return list;

	}

	// obtain total records and total pages
	public static int[] totalPage(int count, String keyword) {
		int[] arr = { 0, 1 };
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "";
			if (keyword != null) {
				sql = "select count(*) from lmonkey_user where USER_NAME like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + keyword + "%");
				
			} else {
				sql = "select count(*) from lmonkey_user";
				ps = conn.prepareStatement(sql);
				
			}
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				arr[0] = rs.getInt(1);
				if (arr[0] % count == 0) {
					arr[1] = arr[0] / count;
				} else {
					arr[1] = arr[0] / count + 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return arr;
	}
	
	//
	public static LMONKEY_USER selectByID(String id) {
		LMONKEY_USER u = null;
		ResultSet rs = null;
		Connection conn = Basedao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "select m.*, DATE_FORMAT(m.USER_BIRTHDAY,'%Y-%m-%d') birthday from lmonkey_user m where USER_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
						u = new LMONKEY_USER(rs.getString("USER_ID"), rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"), rs.getString("USER_SEX"), rs.getString("birthday"),
						rs.getString("USER_IDENITY_CODE"), rs.getString("USER_EMAIL"), rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"), rs.getInt("USER_STATUS"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeAll(rs, ps, conn);
		}

		return u;

	}
	
	//update
	public static int update(LMONKEY_USER u) {
		String sql = "update lmonkey_user set USER_NAME = ?, USER_PASSWORD = ?, USER_SEX = ?, USER_BIRTHDAY=DATE_FORMAT(?, '%Y-%m-%d'), USER_IDENITY_CODE = ?, USER_EMAIL = ?, USER_MOBILE = ?, USER_ADDRESS = ?,  USER_STATUS = ? where USER_ID = ?";
		Object[] params = { u.getUSER_NAME(), u.getUSER_PASSWOR(), u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(), u.getUSER_IDENITY_CODE(), u.getUSER_EMAIL(), u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(), u.getUSER_STATUS(),  u.getUSER_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	
	//delete
	public static int del(String id) {
		String sql = "delete from lmonkey_user where USER_ID = ? and USER_STATUS != 2";
		Object[] params = {id};
		return Basedao.exectuIUD(sql, params);
		
	}
}
	
