package com.harbor.service;

import java.util.List;

import com.harbor.model.User;

public interface IUserService {

	List<User> getAllUsers();

	User findUserById(long userId);

	User login(User user);

	User signup(User user);


}
