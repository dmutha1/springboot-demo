package com.webservices.restful.springbootrestfuldemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		users.add(new User(1, "Raj", new Date()));
		users.add(new User(2, "vamsee", new Date()));
		users.add(new User(3, "vivek", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(Integer id) {

		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public User saveOne(User user) {

		if (user.getId() == null) {
			user.setId(++usersCount);
		}

		users.add(user);
		return user;
	}

}
