package com.retail.retaildiscountapp.model;

import jakarta.validation.constraints.NotNull;

public class User implements IUser {
	
	@NotNull(message="UserId can not be null")
	private String userId;
	private boolean isEmployee;
	private boolean isAffiliate;
	private long memberSinceYears;
	
	
	public User(String userId, boolean isEmployee, boolean isAffiliate, long memberSinceYears) {
		this.userId = userId;
		this.isEmployee = isEmployee;
		this.isAffiliate = isAffiliate;
		this.memberSinceYears = memberSinceYears;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public boolean isAffiliate() {
		return isAffiliate;
	}

	public long getMemberSinceYears() {
		return memberSinceYears;
	}

}
