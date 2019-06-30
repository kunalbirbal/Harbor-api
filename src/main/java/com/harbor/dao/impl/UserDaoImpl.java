package com.harbor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.harbor.dao.IUserDao;
import com.harbor.model.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao{
	
	@PersistenceContext
	private EntityManager emf;

	@Override
	public User findUserById(long userId) {
		// TODO Auto-generated method stub
		User user = emf.find(User.class, userId);		
		return user;
	}
	
	@Override
	public User findUserByUsername(String username) {

		Criteria criteria = emf.unwrap(Session.class).createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));

		return (User) criteria.uniqueResult();
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = emf.unwrap(Session.class).createCriteria(User.class).list();
		return users;
	}
	
	@Override
	public User persistUser(User user) {
		emf.persist(user);
		return user;
		
	}

}
