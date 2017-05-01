/**
 * 
 */
package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.NamedQueryTest;

/**
 * @author MD AZAR
 *
 */
public interface NamedQueryBase extends JpaRepository<NamedQueryTest, Long> {
	

}
