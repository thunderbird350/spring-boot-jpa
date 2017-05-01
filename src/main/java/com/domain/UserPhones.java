/**
 * 
 */
package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author MD AZAR
 *
 */

@Entity
public class UserPhones {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_PHONES_ID")
	private Long id;

	@Column(name = "USER_PHONE_COMPANY")
	private String userPhoneCompany;

	@ManyToOne
	@JoinColumn(name = "USERNAME", referencedColumnName = "NAME")
	@JsonBackReference
	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userPhoneCompany
	 */
	public String getUserPhoneCompany() {
		return userPhoneCompany;
	}

	/**
	 * @param userPhoneCompany
	 *            the userPhoneCompany to set
	 */
	public void setUserPhoneCompany(String userPhoneCompany) {
		this.userPhoneCompany = userPhoneCompany;
	}

}
