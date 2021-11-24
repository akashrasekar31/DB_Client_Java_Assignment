package com.nace.data.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "nace")
@ApiModel(description = "All NACE data")
public class NaceBean {
	
	@Id
	@Column(name = "order_id")
	@ApiModelProperty(notes = "Should not be blank or null")
	private long orderId;
	
	@Column(name = "level")
	private int level;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "parent")
	private String parent;
	
	@Column(name = "description", columnDefinition="TEXT")
	private String description;
	
	@Column(name = "item_includes", columnDefinition="TEXT")
	private String itemIncludes;
	
	@Column(name = "extra_item_includes", columnDefinition="TEXT")
	private String extraItemIncludes;
	
	@Column(name = "rulings")
	private String rulings;
	
	@Column(name = "item_excludes", columnDefinition="TEXT")
	private String itemExcludes;
	
	@Column(name = "reference_id")
	private String referenceId;
	
	public NaceBean() {
		super();
	}


	public NaceBean(long orderId, int level, String code, String parent, String description, String itemIncludes,
			String extraItemIncludes, String rulings, String itemExcludes, String referenceId) {
		super();
		this.orderId = orderId;
		this.level = level;
		this.code = code;
		this.parent = parent;
		this.description = description;
		this.itemIncludes = itemIncludes;
		this.extraItemIncludes = extraItemIncludes;
		this.rulings = rulings;
		this.itemExcludes = itemExcludes;
		this.referenceId = referenceId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemIncludes() {
		return itemIncludes;
	}

	public void setItemIncludes(String itemIncludes) {
		this.itemIncludes = itemIncludes;
	}

	public String getExtraItemIncludes() {
		return extraItemIncludes;
	}

	public void setExtraItemIncludes(String extraItemIncludes) {
		this.extraItemIncludes = extraItemIncludes;
	}

	public String getRulings() {
		return rulings;
	}

	public void setRulings(String rulings) {
		this.rulings = rulings;
	}

	public String getItemExcludes() {
		return itemExcludes;
	}

	public void setItemExcludes(String itemExcludes) {
		this.itemExcludes = itemExcludes;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
	
	
}
