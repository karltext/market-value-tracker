package com.groupproject.RoleLog;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="RoleLog")
@XmlRootElement //Declares the automatic mapping of java to XML/JSON 
public class RoleHours {
	
	int inputID;
	
	@FormParam("role")
	String role;
	
	@FormParam("hours")
	int hours;
	/*
	//@FormParam("date")
	Timestamp currentDate;
	*/
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
	/*
	public Timestamp getCurrentDate() {
		return currentDate;
	}
	*/
	
	
	
	

}
