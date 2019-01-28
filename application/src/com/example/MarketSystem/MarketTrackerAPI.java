package com.example.MarketSystem;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.MarketSystem.MarketTrackerJPA;
import com.example.MarketSystem.Role;

@Component
@Path("/role/")
public class MarketTrackerAPI {
	
	MarketTrackerJPA repository ;

	public MarketTrackerJPA getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(MarketTrackerJPA repository) {
		this.repository = repository;
	}
	
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Role> listAccounts(){
		return getRepository().findAll();
	}
	
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Role addAccount(@BeanParam Role newRole) {
		getRepository().save(newRole);
		return newRole ;
	}

}
