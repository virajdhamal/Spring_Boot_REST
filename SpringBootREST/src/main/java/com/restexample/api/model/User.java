package com.restexample.api.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User model description") // for swagger info
public class User {
	private long userId;
	@Size(min=2,message="Username should be more than 2 chars") // validation notations
	@ApiModelProperty(notes="Username should be more than 2 chars") // for swagger info
	private String name;
	@Past // validation notations
	@ApiModelProperty(notes="Birthdate should be in past") // for swagger info
	private Date birtDate;
	
	public User() {}
	
	public User(long userId, String name, Date birtDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.birtDate = birtDate;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirtDate() {
		return birtDate;
	}
	public void setBirtDate(Date birtDate) {
		this.birtDate = birtDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", birtDate=" + birtDate + "]";
	}
	
	
}
