package com.app.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the USER_REGISTRATION database table.
 * 
 */
@Entity
@Table(name="USER_REGISTRATION")
@NamedQuery(name="UserRegistration.findAll", query="SELECT u FROM UserRegistration u")
public class UserRegistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_REG_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userRegId;

	@Column(name="USER_REG_ADDRESS")
	private String userRegAddress;

	@Column(name="USER_REG_EMAIL")
	private String userRegEmail;

	@Column(name="USER_REG_FULLNAME")
	private String userRegFullname;

	@Column(name="USER_REG_PASS")
	private String userRegPass;

	@Column(name="USER_REG_PHONE")
	private String  userRegPhone;
	/*
	@Column(name="USER_ROLE")
	private String  userRole;*/

	//bi-directional many-to-one association to CenterLocation
	@ManyToOne
	@JoinColumn(name="USER_REG_CENTER_LOC")
	private CenterLocation centerLocation;

	public UserRegistration() {
	}
	
/*
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}*/

	public long getUserRegId() {
		return this.userRegId;
	}

	public void setUserRegId(long l) {
		this.userRegId = l;
	}

	public String getUserRegAddress() {
		return this.userRegAddress;
	}

	public void setUserRegAddress(String userRegAddress) {
		this.userRegAddress = userRegAddress;
	}

	public String getUserRegEmail() {
		return this.userRegEmail;
	}

	public void setUserRegEmail(String userRegEmail) {
		this.userRegEmail = userRegEmail;
	}

	public String getUserRegFullname() {
		return this.userRegFullname;
	}

	public void setUserRegFullname(String userRegFullname) {
		this.userRegFullname = userRegFullname;
	}

	public String getUserRegPass() {
		return this.userRegPass;
	}

	public void setUserRegPass(String userRegPass) {
		this.userRegPass = userRegPass;
	}

	public String getUserRegPhone() {
		return this.userRegPhone;
	}

	public void setUserRegPhone(String userRegPhone) {
		this.userRegPhone = userRegPhone;
	}

	public CenterLocation getCenterLocation() {
		return this.centerLocation;
	}

	public void setCenterLocation(CenterLocation centerLocation2) {
		this.centerLocation=centerLocation2; 
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRegId == null) ? 0 : userRegId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRegistration other = (UserRegistration) obj;
		if (userRegId == null) {
			if (other.userRegId != null)
				return false;
		} else if (!userRegId.equals(other.userRegId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRegistration [userRegId=" + userRegId + ", userRegAddress=" + userRegAddress + ", userRegEmail="
				+ userRegEmail + ", userRegFullname=" + userRegFullname + ", userRegPass=" + userRegPass
				+ ", userRegPhone=" + userRegPhone + ", centerLocation=" + centerLocation + "]";
	}
	
	
}