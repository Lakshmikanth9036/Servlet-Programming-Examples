package com.Biditvats.db;

import java.util.HashMap;
import java.util.Map;

import com.Biditvats.domain.User;

public class Database {
	
	private static Map<String, User> userMap = null;
	
	public static boolean saveUser(User user){
		if(userMap == null)
			userMap = new HashMap<>();
		
		if(userMap.containsKey(user.getEmail())){
			return false;
		}else {
			userMap.put(user.getEmail(), user);
			return true;
		}
	}
	
	public static User getUser(String email){
		if(userMap == null)
			userMap = new HashMap<>();
		
		return userMap.get(email);
	}
}
