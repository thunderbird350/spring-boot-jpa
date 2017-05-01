/**
 * 
 */
package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.User;

/**
 * @author MD AZAR
 *
 */

public interface UserBaseRepository extends JpaRepository<User, Long> {

	List<User> findAll();

	public void deleteByName(String name);

}
