package com.Biditvats.dao;

import java.util.List;

import com.Biditvats.domain.User;

public interface UserDao {
	public boolean saveUser(User user);

	public User findUserByEmailAndPassword(String email, String password);
	
	public List<User> findAllUser();
}
