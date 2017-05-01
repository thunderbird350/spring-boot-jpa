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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author MD AZAR
 *
 */

@Entity
@Table(name = "TUSERROLE")
public class UserRole {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLEID")
	private Long roleId;

	@Column(name = "ROLENAME")
	private String role;

	@OneToOne
	@JoinColumn(name = "USERNAME", referencedColumnName = "NAME")
	@JsonBackReference
	private User user;

	/**
	 * @return the userName
	 */
	/*
	 * public String getUserName() { return userName; }
	 *//**
	 * @param userName
	 *            the userName to set
	 */
	/*
	 * public void setUserName(String userName) { this.userName = userName; }
	 */

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
	 * @return the roleId
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return role;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.role = roleName;
	}

}
