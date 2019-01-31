package com.mastek.valuetracker.profile;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="vt_profile")
@XmlRootElement
public class Profile {

	int profileId;
	
	@FormParam("username")
	String username;
	
	@FormParam("salary")
	double salary;
	
	@FormParam("profileRank")
	int profileRank;
	
	@JsonIgnore
	Set<Skill> skills;
	
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
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getProfileRank() {
		return profileRank;
	}
	public void setProfileRank(int profileRank) {
		this.profileRank = profileRank;
	}
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="HIB_Registrations", 
			  joinColumns={@JoinColumn(name="FK_Profile_Id")},
			  inverseJoinColumns={@JoinColumn(name="FK_Skill_Id")})
	public Set<Skill> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", username=" + username + "]";
	}
}
