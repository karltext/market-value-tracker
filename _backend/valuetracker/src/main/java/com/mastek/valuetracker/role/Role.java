package com.mastek.valuetracker.role;


import java.util.Date;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mastek.valuetracker.profile.Profile;

import org.hibernate.annotations.Type;

@Entity
@Table(name="vt_role")
@XmlRootElement
public class Role {

	@FormParam("id")
	int id;
	
	@FormParam("skill")
	String skill;
	
	@FormParam("rank")
	int role_rank;
	
	@FormParam("rank_change")
	int rank_change;
	
	@FormParam("median_salary")
	double median_salary;
	
	@FormParam("median_change")
	double median_change;
	
	@FormParam("historical_ads")
	int historical_ads;
	
	@FormParam("ad_percentage")
	double ad_percentage;
	
	@FormParam("live_vacancies")
	int live_vacancies;
	
	@FormParam("updated")
	Date updated;	
	
	Set<Profile> profiles;

	@Override
	public String toString() {
		return "Role [id=" + id + ", skill=" + skill + ", rank=" + role_rank + ", rank_change=" + rank_change
				+ ", median_salary=" + median_salary + ", median_change=" + median_change + ", historical_ads="
				+ historical_ads + ", ad_percentage=" + ad_percentage + ", live_vacancies=" + live_vacancies
				+ ", updated=" + updated + "]";
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}

	
	public int getRole_rank() {
		return role_rank;
	}

	public void setRole_rank(int role_rank) {
		this.role_rank = role_rank;
	}

	public int getRank_change() {
		return rank_change;
	}
	public void setRank_change(int rank_change) {
		this.rank_change = rank_change;
	}
	public double getMedian_salary() {
		return median_salary;
	}
	public void setMedian_salary(double median_salary) {
		this.median_salary = median_salary;
	}
	public double getMedian_change() {
		return median_change;
	}
	public void setMedian_change(double median_change) {
		this.median_change = median_change;
	}
	public int getHistorical_ads() {
		return historical_ads;
	}
	public void setHistorical_ads(int historical_ads) {
		this.historical_ads = historical_ads;
	}
	public double getAd_percentage() {
		return ad_percentage;
	}
	public void setAd_percentage(double ad_percentage) {
		this.ad_percentage = ad_percentage;
	}
	public int getLive_vacancies() {
		return live_vacancies;
	}
	public void setLive_vacancies(int live_vacancies) {
		this.live_vacancies = live_vacancies;
	}

	
	@Version
	@Type(type = "dbtimestamp")
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	

	@ManyToMany(mappedBy="roles")
	@XmlTransient 
	public Set<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

}