package edu.sjtu.shop.recomSys.pojo;

/**
 * VenueNyc entity. @author MyEclipse Persistence Tools
 */

public class VenueNyc implements java.io.Serializable {

	// Fields

	private String venueId;
	private String venueName;
	private Double la;
	private Double lo;
	private String address;
	private String venueCity;
	private String state;
	private Long checkinNum;
	private Long checkinUser;
	private Long currentUser;
	private Long todo;
	private Long categoryNum;

	// Constructors

	/** default constructor */
	public VenueNyc() {
	}

	/** minimal constructor */
	public VenueNyc(String venueId) {
		this.venueId = venueId;
	}

	/** full constructor */
	public VenueNyc(String venueId, String venueName, Double la, Double lo,
			String address, String venueCity, String state, Long checkinNum,
			Long checkinUser, Long currentUser, Long todo, Long categoryNum) {
		this.venueId = venueId;
		this.venueName = venueName;
		this.la = la;
		this.lo = lo;
		this.address = address;
		this.venueCity = venueCity;
		this.state = state;
		this.checkinNum = checkinNum;
		this.checkinUser = checkinUser;
		this.currentUser = currentUser;
		this.todo = todo;
		this.categoryNum = categoryNum;
	}

	// Property accessors

	public String getVenueId() {
		return this.venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return this.venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public Double getLa() {
		return this.la;
	}

	public void setLa(Double la) {
		this.la = la;
	}

	public Double getLo() {
		return this.lo;
	}

	public void setLo(Double lo) {
		this.lo = lo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVenueCity() {
		return this.venueCity;
	}

	public void setVenueCity(String venueCity) {
		this.venueCity = venueCity;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getCheckinNum() {
		return this.checkinNum;
	}

	public void setCheckinNum(Long checkinNum) {
		this.checkinNum = checkinNum;
	}

	public Long getCheckinUser() {
		return this.checkinUser;
	}

	public void setCheckinUser(Long checkinUser) {
		this.checkinUser = checkinUser;
	}

	public Long getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(Long currentUser) {
		this.currentUser = currentUser;
	}

	public Long getTodo() {
		return this.todo;
	}

	public void setTodo(Long todo) {
		this.todo = todo;
	}

	public Long getCategoryNum() {
		return this.categoryNum;
	}

	public void setCategoryNum(Long categoryNum) {
		this.categoryNum = categoryNum;
	}

}