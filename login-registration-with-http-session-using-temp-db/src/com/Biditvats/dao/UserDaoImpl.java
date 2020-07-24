package com.Biditvats.dao;

import com.Biditvats.db.Database;
import com.Biditvats.domain.User;

public class UserDaoImpl implements UserDao {
	
	private static UserDao userDao = null;
	
	private UserDaoImpl() {
		//Do Nothing
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return Database.saveUser(user);
	}

	@Override
	public User getUserByemail(String email) {
		// TODO Auto-generated method stub
		return Database.getUser(email);
	}
	
	//Creating Singleton Object
	public static UserDao getIntance() {
		if(userDao == null)
			userDao = new UserDaoImpl();
		return userDao;
	}
}
