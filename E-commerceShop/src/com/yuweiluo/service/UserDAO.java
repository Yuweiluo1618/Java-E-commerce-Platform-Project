package com.yuweiluo.service;

import com.yuweiluo.dao.Basedao;
import com.yuweiluo.entity.LMONKEY_USER;

public class UserDAO {

	public static int insert(LMONKEY_USER u) {
		String sql = "insert into lmonkey_user values(?,?,?,?,DATE_FORMAT(?,'%y-%m-%d'),?,?,?,?,?)";
		Object[] params = { u.getUSER_ID(), u.getUSER_NAME(), u.getUSER_PASSWOR(), u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(), u.getUSER_IDENITY_CODE(), u.getUSER_EMAIL(), u.getUSER_MOBILE(), u.getUSER_ADDRESS(),
				u.getUSER_STATUS() };
		return Basedao.exectuIUD(sql, params);
	}

}
	
	
