/**
 * 
 */
package com.service;

import java.util.List;

import com.domain.User;

/**
 * @author MD AZAR
 *
 */
public interface UserService {

	List<User> findAll();

	public void deleteUser(String name);

	public void saveUser(User user);

}
