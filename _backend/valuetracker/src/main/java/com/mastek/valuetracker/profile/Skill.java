package com.mastek.valuetracker.profile;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="vt_profile_skill")
@XmlRootElement
public class Skill {
	
	int skillId;
	
	@FormParam("skillName")
	String skillName;
	
	Set<Profile> profiles;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
	@ManyToMany(mappedBy="skills")
	@XmlTransient 
	public Set<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	
}
