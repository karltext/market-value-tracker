package com.mastek.valuetracker.profile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="vt_profile")
@XmlRootElement
public class Profile {

	@FormParam("profileId")
	int profileId;
	
	@FormParam("username")
	String username;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", username=" + username + "]";
	}
}
