/**
 * 
 */
package com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.User;
import com.repository.UserBaseRepository;
import com.service.UserService;

/**
 * @author MD AZAR
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserBaseRepository userBaseRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.azar.service.UserService#findAll()
	 */
	@Override
	public List<User> findAll() {

		return userBaseRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.UserService#saveUser(com.domain.User)
	 */
	@Override
	public void saveUser(User user) {
		userBaseRepository.save(user);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.service.UserService#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String name) {
		userBaseRepository.deleteByName(name);

	}

}
