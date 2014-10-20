package edu.sjtu.shop.recomSys.pojo;

import java.math.BigDecimal;

/**
 * PoiMonth entity. @author MyEclipse Persistence Tools
 */

public class PoiMonth implements java.io.Serializable {

	// Fields

	private Long id;
	private PathMonth pathMonth;
	private String pointId;
	private Integer levelId;
	private String datetime;

	// Constructors

	/** default constructor */
	public PoiMonth() {
	}

	/** full constructor */
	public PoiMonth(Long id, PathMonth pathMonth, String pointId,
			Integer levelId, String datetime) {
		this.id = id;
		this.pathMonth = pathMonth;
		this.pointId = pointId;
		this.levelId = levelId;
		this.datetime = datetime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PathMonth getPathMonth() {
		return this.pathMonth;
	}

	public void setPathMonth(PathMonth pathMonth) {
		this.pathMonth = pathMonth;
	}

	public String getPointId() {
		return this.pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}