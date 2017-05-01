/**
 * 
 */
package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MD AZAR
 *
 */
@Entity
@Table(name="GENERAL_TEST")
public class NamedQueryTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="MOVIE")
	private String movie;
	
	@Column(name="USER_ID")
	private String userId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the movie
	 */
	public String getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(String movie) {
		this.movie = movie;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId2 the userId to set
	 */
	public void setUserId(String userId2) {
		this.userId = userId2;
	}

}
