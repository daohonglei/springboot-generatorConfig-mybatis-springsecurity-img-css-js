package com.mjly.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDao {

	

	public UserInfo getDatabase(String username) {
		List<UserInfo> users = internalDatabase();

		for (UserInfo dbUser : users) {
			if (dbUser.getUsername().equals(username) == true) {
				return dbUser;
			}
		}
		throw new RuntimeException("User does not exist!");
	}

	/**
	 * 初始化数据
	 */
	private List<UserInfo> internalDatabase() {

		List<UserInfo> users = new ArrayList<UserInfo>();
		UserInfo user = null;

		//密码 admin
		user = new UserInfo(1,"admin","6d789d4353c72e4f625d21c6b7ac2982",true,1);
		users.add(user);

		//密码 user
		user =new UserInfo(2,"user","36f1cab655c5252fc4f163a1409500b8",true,2);
		users.add(user);

		return users;

	}
}
