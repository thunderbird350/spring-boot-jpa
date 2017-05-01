/**
 * 
 *//*
package com.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

*//**
 * @author MD AZAR
 *
 *//*
@NoRepositoryBean
@Component
public interface NamedQuery extends JpaRepository{
	
	
	@Query(value="SELECT t1.ID,t1.MOVIE,t2.NAME,t2.SURNAME FROM GENERAL_TEST t1"
			+ "INNER JOIN ON USER_INFO t2 WHERE t1.USER_ID=t2.NAME")
	List<Object[]> findallData();
	
	

}
*/