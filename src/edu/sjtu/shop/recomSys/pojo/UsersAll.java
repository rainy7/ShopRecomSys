package edu.sjtu.shop.recomSys.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * UsersAll entity. @author MyEclipse Persistence Tools
 */

public class UsersAll implements java.io.Serializable {

	// Fields

	private Long userId;
	private String firstName;
	private String lastName;
	private String icon;
	private String gender;
	private String userCity;
	private Set paths = new HashSet(0);

	// Constructors

	/** default constructor */
	public UsersAll() {
	}

	/** minimal constructor */
	public UsersAll(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public UsersAll(Long userId, String firstName, String lastName,
			String icon, String gender, String userCity, Set paths) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.icon = icon;
		this.gender = gender;
		this.userCity = userCity;
		this.paths = paths;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public Set getPaths() {
		return this.paths;
	}

	public void setPaths(Set paths) {
		this.paths = paths;
	}

}