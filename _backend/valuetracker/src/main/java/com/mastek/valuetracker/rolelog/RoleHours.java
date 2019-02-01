package com.mastek.valuetracker.rolelog;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mastek.valuetracker.role.Role;


@Entity
@Table(name="vt_role_hours")
@XmlRootElement //Declares the automatic mapping of java to XML/JSON 
public class RoleHours {
	
	int inputID;
	
	@FormParam("role")
	String role;
	
	@FormParam("hours")
	int hours;
	
	@FormParam("charge")
	double charge;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getInputID() {
		return inputID;
	}
	public void setInputID(int inputID) {
		this.inputID = inputID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	@Override
	public String toString() {
		return "RoleHours [inputID=" + inputID + ", role=" + role + ", hours=" + hours + "]";
	}
	
	
	
	
	
	
	

}
