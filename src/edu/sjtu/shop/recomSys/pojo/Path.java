package edu.sjtu.shop.recomSys.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Path entity. @author MyEclipse Persistence Tools
 */

public class Path implements java.io.Serializable {

	// Fields

	private Long pathId;
	private UsersAll usersAll;
	private Date datetime;
	private Integer levelId;
	private Set pois = new HashSet(0);

	// Constructors

	/** default constructor */
	public Path() {
	}

	/** minimal constructor */
	public Path(Long pathId, UsersAll usersAll, Date datetime,
			Integer levelId) {
		this.pathId = pathId;
		this.usersAll = usersAll;
		this.datetime = datetime;
		this.levelId = levelId;
	}

	/** full constructor */
	public Path(Long pathId, UsersAll usersAll, Date datetime,
			Integer levelId, Set pois) {
		this.pathId = pathId;
		this.usersAll = usersAll;
		this.datetime = datetime;
		this.levelId = levelId;
		this.pois = pois;
	}

	// Property accessors

	public Long getPathId() {
		return this.pathId;
	}

	public void setPathId(Long pathId) {
		this.pathId = pathId;
	}

	public UsersAll getUsersAll() {
		return this.usersAll;
	}

	public void setUsersAll(UsersAll usersAll) {
		this.usersAll = usersAll;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public Set getPois() {
		return this.pois;
	}

	public void setPois(Set pois) {
		this.pois = pois;
	}

}