package edu.sjtu.shop.recomSys.pojo;

import java.math.BigDecimal;

/**
 * VeNyc entity. @author MyEclipse Persistence Tools
 */

public class VeNyc implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String venueId;
	private String categoryId;

	// Constructors

	/** default constructor */
	public VeNyc() {
	}

	/** minimal constructor */
	public VeNyc(BigDecimal id, String venueId) {
		this.id = id;
		this.venueId = venueId;
	}

	/** full constructor */
	public VeNyc(BigDecimal id, String venueId, String categoryId) {
		this.id = id;
		this.venueId = venueId;
		this.categoryId = categoryId;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getVenueId() {
		return this.venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}