package com.app.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CENTER_LOCATION database table.
 * 
 */
@Entity
@Table(name="CENTER_LOCATION")
@NamedQuery(name="CenterLocation.findAll", query="SELECT c FROM CenterLocation c")
public class CenterLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CENTER_ID")
	private long centerId;

	@Column(name="CENTER_ADDRESS")
	private String centerAddress;

	@Column(name="CENTER_NAME")
	private String centerName;

	//bi-directional many-to-one association to UserRegistration
	//@OneToMany(mappedBy="centerLocation")
	//private List<UserRegistration> userRegistrations;

	public CenterLocation() {
	}
	
	

	public CenterLocation(String centerName, String centerAddress) {
		super();
		this.centerAddress = centerAddress;
		this.centerName = centerName;
	}



	public long getCenterId() {
		return this.centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}

	public String getCenterAddress() {
		return this.centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	public String getCenterName() {
		return this.centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}



	@Override
	public String toString() {
		return "CenterLocation [centerId=" + centerId + ", centerAddress=" + centerAddress + ", centerName="
				+ centerName + "]";
	}

	
	
	
	
//	public List<UserRegistration> getUserRegistrations() {
//		return this.userRegistrations;
//	}

/*	public void setUserRegistrations(List<UserRegistration> userRegistrations) {
		this.userRegistrations = userRegistrations;
	}
*/
	/*public UserRegistration addUserRegistration(UserRegistration userRegistration) {
		getUserRegistrations().add(userRegistration);
		userRegistration.setCenterLocation(centerLocation);

		return userRegistration;
	}*/

	/*public UserRegistration removeUserRegistration(UserRegistration userRegistration) {
		getUserRegistrations().remove(userRegistration);
		userRegistration.setCenterLocation(null);

		return userRegistration;
	}
*/

}