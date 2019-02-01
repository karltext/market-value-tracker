package com.mastek.valuetracker.rolelog;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.valuetracker.role.Role;



@Component
@Path("/rolehours")
public class RoleHoursAPI {
	
	RoleHoursRepository repository;

	public RoleHoursRepository getRepository() {
		return repository;
	}
	@Autowired
	public void setRepository(RoleHoursRepository repository) {
		this.repository = repository;
	}
	
	@Path("/list")
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

	@Path("/findByRole")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Double> findByRole(@QueryParam("skill") String skill) {
    	List<Double> salaryList = new ArrayList<Double>();
    	for (Double roles : getRepository().findByRole(skill)) {
    		salaryList.add(roles);
		}
        return salaryList; 
    }

	
	
}
