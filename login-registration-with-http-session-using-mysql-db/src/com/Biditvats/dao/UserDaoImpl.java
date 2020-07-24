package com.Biditvats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.Biditvats.db.Database;
import com.Biditvats.domain.User;

public class UserDaoImpl implements UserDao {

	private static UserDao userDao = null;
	private Connection connection = Database.getConnection();

	private UserDaoImpl() {
		// Do Nothing
	}

	@Override
	public boolean saveUser(User user) {
		String sql = "INSERT INTO user_master(first_name,last_name,email,mobile,password) VALUES(?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getMobile());
			preparedStatement.setString(5, user.getPassword());

			i = preparedStatement.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		if (i > 0)
			return true;

		return false;
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		String sql = "SELECT * FROM user_master WHERE email=? AND password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setMobile(resultSet.getString(5));

				return user;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		
		return null;
	}

	@Override
	public List<User> findAllUser() {
		String sql = "SELECT * FROM user_master";
		List<User> users = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if(users==null)
					users = new LinkedList<>();
					
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setFirstName(resultSet.getString(2));
				user.setLastName(resultSet.getString(3));
				user.setEmail(resultSet.getString(4));
				user.setMobile(resultSet.getString(5));
				
				users.add(user);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return users;
	}

	// Creating Singleton Object
	public static UserDao getIntance() {
		if (userDao == null)
			userDao = new UserDaoImpl();
		return userDao;
	}
}
