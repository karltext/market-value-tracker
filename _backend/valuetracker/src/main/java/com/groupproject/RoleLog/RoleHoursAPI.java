package com.groupproject.RoleLog;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Path("/RoleLog/")
public class RoleHoursAPI {
	
	RoleHoursRepository repository;

	public RoleHoursRepository getRepository() {
		return repository;
	}
	@Autowired
	public void setRepository(RoleHoursRepository repository) {
		this.repository = repository;
	}
	
	@Path("/RoleHours")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<RoleHours> listRoleHours(){
		return getRepository().findAll();
		
	}
	
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public RoleHours addRoleHours(@BeanParam RoleHours newRoleHours) {
		getRepository().save(newRoleHours);
		return newRoleHours;
		
	}
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public RoleHours deleteRoleHours(int inputID) {
		RoleHours deleteRoleHours = getRepository().findById(inputID).get();
		getRepository().delete(deleteRoleHours);
		return deleteRoleHours;
	}
	
	

}
