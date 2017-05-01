/**
 * 
 */
package com.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author MD AZAR
 *
 *         This class holds the ownership of the relationships
 */
@Entity
@Table(name = "USER_INFO")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private UserRole userRole;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<UserPhones> userPhones;

	/**
	 * @return the userPhones
	 */
	public List<UserPhones> getUserPhones() {
		return userPhones;
	}

	/**
	 * @param userPhones
	 *            the userPhones to set
	 */
	public void setUserPhones(List<UserPhones> userPhones) {
		this.userPhones = userPhones;
	}

	/**
	 * @return the userRole
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

}
