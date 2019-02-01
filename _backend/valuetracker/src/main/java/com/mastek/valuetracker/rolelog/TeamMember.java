package com.mastek.valuetracker.rolelog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="team")
@XmlRootElement
public class TeamMember {

	@FormParam("id")
	int roleId;
	@FormParam("roleName")
	String roleName = "Developer";
	@FormParam("salary")
	int salary = 10000;
	@FormParam("hourlySalary")
	int hourlySalary; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getHourlySalary() {
		return hourlySalary;
	}
	public void setHourlySalary(int hourlySalary) {
		this.hourlySalary = hourlySalary ;
	}
	
	@Override
	public String toString() {
		return "TeamMember [roleId=" + roleId + ", roleName=" + roleName + ", salary=" + salary + ", hourlySalary="
				+ hourlySalary + "]";
	}
	
	
	
	
	
}
