package com.restexample.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restexample.api.model.User;

@Component
public class UserServices {
	private static List<User> listUsers=new ArrayList<>();
	private int usercount=3;
	static {
		listUsers.add(new User(1, "Viraj", new Date()));
		listUsers.add(new User(2, "Kiran", new Date()));
		listUsers.add(new User(3, "Nitesh", new Date()));
	}
	
	public List<User> findAll(){
		return listUsers;
	}
	
	public User save(User user) {
		if (user.getUserId()==0) {
			user.setUserId(++usercount);
		}
		listUsers.add(user);	
		return user;
	}
	
	public User findOne(long userId) {
		for (User user : listUsers) {
			if (user.getUserId()==userId) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteOne(long userId) {
		Iterator<User> itr=listUsers.iterator();
		while (itr.hasNext()) {
			User user=itr.next();
			if (user.getUserId()==userId) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
