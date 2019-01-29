package com.mastek.valuetracker;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
@Path("/roles/")
public class RoleAccessAPI{
    RoleJPARepository repository;
    public RoleJPARepository getRepository() {
        return repository;
    }
    @Autowired
    public void setRepository(RoleJPARepository repository) {
        this.repository = repository;
    }
    
    @Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Role> listRoles(){
		return getRepository().findAll();
	}
    
    @Path("/findById")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Role findById(@QueryParam("id") int id) {
        return getRepository().findById(id).get(); 
    }
    
    @Path("/findByRole")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Role> findByRole(@QueryParam("skill") String skill) {
    	List<Role> roleList = new ArrayList<Role>();
    	for (Role roles : getRepository().findByRole(skill)) {
    		roleList.add(roles);
		}
        return roleList; 
    }
    
    public Role add(Role i) {
        return getRepository().save(i);
    }
    
}