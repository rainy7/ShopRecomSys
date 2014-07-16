package edu.sjtu.shop.recomSys.pojo;

import java.math.BigDecimal;

/**
 * TipsAll entity. @author MyEclipse Persistence Tools
 */

public class TipsAll implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String venueId;
	private Long userId;
	private String text;
	private String createdTime;
	private Long todo;
	private Long done;

	// Constructors

	/** default constructor */
	public TipsAll() {
	}

	/** minimal constructor */
	public TipsAll(BigDecimal id, Long userId) {
		this.id = id;
		this.userId = userId;
	}

	/** full constructor */
	public TipsAll(BigDecimal id, String venueId, Long userId, String text,
			String createdTime, Long todo, Long done) {
		this.id = id;
		this.venueId = venueId;
		this.userId = userId;
		this.text = text;
		this.createdTime = createdTime;
		this.todo = todo;
		this.done = done;
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

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public Long getTodo() {
		return this.todo;
	}

	public void setTodo(Long todo) {
		this.todo = todo;
	}

	public Long getDone() {
		return this.done;
	}

	public void setDone(Long done) {
		this.done = done;
	}

}