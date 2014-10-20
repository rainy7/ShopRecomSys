package edu.sjtu.shop.recomSys.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PathMonth entity. @author MyEclipse Persistence Tools
 */

public class PathMonth implements java.io.Serializable {

	// Fields

	private Long pathId;
	private UsersAll usersAll;
	private Date datetime;
	private Integer levelId;
	private Integer poiNumber;
	private Set poiMonths = new HashSet(0);

	// Constructors

	/** default constructor */
	public PathMonth() {
	}

	/** minimal constructor */
	public PathMonth(Long pathId, UsersAll usersAll, Date datetime,
			Integer levelId) {
		this.pathId = pathId;
		this.usersAll = usersAll;
		this.datetime = datetime;
		this.levelId = levelId;
	}

	/** full constructor */
	public PathMonth(Long pathId, UsersAll usersAll, Date datetime,
			Integer levelId, Set poiMonths) {
		this.pathId = pathId;
		this.usersAll = usersAll;
		this.datetime = datetime;
		this.levelId = levelId;
		this.poiMonths = poiMonths;
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

	public Integer getPoiNumber() {
		return poiNumber;
	}

	public void setPoiNumber(Integer poiNumber) {
		this.poiNumber = poiNumber;
	}

	public Set getPoiMonths() {
		return this.poiMonths;
	}

	public void setPoiMonths(Set poiMonths) {
		this.poiMonths = poiMonths;
	}

}