package com.mastek.valuetracker.profile;

import javax.ws.rs.FormParam;

public class Registration {
	
	@FormParam("skillId")
	int skillId;
	
	@FormParam("profileId")
	int profileId;
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	@Override
	public String toString() {
		return "Registration [skillId=" + skillId + ", profileId=" + profileId + "]";
	}
}
