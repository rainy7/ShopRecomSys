package edu.sjtu.shop.recomSys.pojo;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private String categoryId;
	private String name;
	private String pluarlName;
	private String icon;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String categoryId) {
		this.categoryId = categoryId;
	}

	/** full constructor */
	public Category(String categoryId, String name, String pluarlName,
			String icon) {
		this.categoryId = categoryId;
		this.name = name;
		this.pluarlName = pluarlName;
		this.icon = icon;
	}

	// Property accessors

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPluarlName() {
		return this.pluarlName;
	}

	public void setPluarlName(String pluarlName) {
		this.pluarlName = pluarlName;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}