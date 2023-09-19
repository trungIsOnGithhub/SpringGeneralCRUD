package com.nvtrung.genericcrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "generic_item")
public class GenericItem {
	@Id
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "int_attr")
	private int intAttribute;
	
	@Column(name = "long_attr")
	private long longAttribute;
	
	@Column(name = "bool_attr")
	private boolean boolAttribute;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntAttribute() {
		return intAttribute;
	}
	public void setIntAttribute(int intAttribute) {
		this.intAttribute = intAttribute;
	}
	public long getLongAttribute() {
		return longAttribute;
	}
	public void setLongAttribute(long longAttribute) {
		this.longAttribute = longAttribute;
	}
	public boolean isBoolAttribute() {
		return boolAttribute;
	}
	public void setBoolAttribute(boolean boolAttribute) {
		this.boolAttribute = boolAttribute;
	}
}