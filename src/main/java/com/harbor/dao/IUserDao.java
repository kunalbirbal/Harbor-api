package com.harbor.dao;

import java.util.List;

import com.harbor.model.User;

public interface IUserDao {
	User findUserById(long userId);

	List<User> getAllUsers();

	User persistUser(User user);

	User findUserByUsername(String username);

}
