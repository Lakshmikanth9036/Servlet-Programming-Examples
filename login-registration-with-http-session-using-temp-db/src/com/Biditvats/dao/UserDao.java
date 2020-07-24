package com.Biditvats.dao;

import com.Biditvats.domain.User;

public interface UserDao {
	public boolean saveUser(User user);
	
	public User getUserByemail(String email);
}
