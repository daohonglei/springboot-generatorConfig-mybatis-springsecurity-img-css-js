package com.mjly.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	private List<User> users=new ArrayList<>();
	public void add(User user) {
		users.add(user);
	}
	
	public List<User> list() {
		return users;
	}
}
