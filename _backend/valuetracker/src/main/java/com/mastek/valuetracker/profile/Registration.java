package com.mastek.valuetracker.profile;

import javax.ws.rs.FormParam;

public class Registration {
	
	@FormParam("roleId")
	int roleId;
	
	@FormParam("profileId")
	int profileId;
	
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	@Override
	public String toString() {
		return "Registration [roleId=" + roleId + ", profileId=" + profileId + "]";
	}

	
}
