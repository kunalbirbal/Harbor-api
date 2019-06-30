package com.harbor.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harbor.dao.IUserDao;
import com.harbor.model.User;
import com.harbor.security.JwtGenerator;
import com.harbor.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtGenerator jwtGenerator;

	@Override
	public List<User> getAllUsers() {

		return userDao.getAllUsers();

	}

	@Override
	public User findUserById(long userId) {

		return userDao.findUserById(userId);

	}

	@Override
	public User signup(User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.persistUser(user);

		user.setAuthtoken(jwtGenerator.generate(user));

		return user;

	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub

		User savedUser = userDao.findUserByUsername(user.getUsername());
		if (bCryptPasswordEncoder.matches(user.getPassword(), savedUser.getPassword())) {
			savedUser.setAuthtoken(jwtGenerator.generate(savedUser));
			return savedUser;
		}

		return null;
	}

}
