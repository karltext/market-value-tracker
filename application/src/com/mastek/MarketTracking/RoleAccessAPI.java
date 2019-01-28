package com.mastek.MarketTracking;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("/Role/")
public class RoleAccessAPI {

	RoleJPARepository repository;

	public RoleJPARepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(RoleJPARepository repository) {
		this.repository = repository;
	}
	
	public Role findById(int id) {
		return getRepository().findById(id).get(); 
	}
	
	public Role add(Role i) {
		return getRepository().save(i);
	}
	
}