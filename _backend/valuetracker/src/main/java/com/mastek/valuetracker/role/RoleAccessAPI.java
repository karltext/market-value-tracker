package com.mastek.valuetracker.role;

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
@Path("/roles")
public class RoleAccessAPI {
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
	public Iterable<Role> listRoles() {
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
    
    @Path("/findOneByRole")
   	@GET
   	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
       public List<Role> findOneByRole(@QueryParam("skill") String skill) {
       	List<Role> roleList = new ArrayList<Role>();
       	for (Role roles : getRepository().findByRole(skill)) {
       		roleList.add(roles);
   		}
           return roleList; 
       }

    @Path("/findAggregateByRole")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Role> findAggregateByRole(@QueryParam("skill") String skill) {
    	List<Role> roleList = new ArrayList<Role>();
    	for (Role roles : getRepository().findAggregateByRole(skill)) {
    		roleList.add(roles);
		}
        return roleList;
    }
    
    @Path("/listInOrder")
   	@GET
   	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
       public List<Role> listAllInOrder(@QueryParam("field") int field) {
    	List<Role> roles = new ArrayList<Role>();
        switch (field) {
            case 1:  roles = getRepository().listAllBySkill();
                     break;
            case 2:  roles = getRepository().listAllByRank();
                     break;
            case 3:  roles = getRepository().listAllByRankChange();
                     break;
            case 4:  roles = getRepository().listAllByMedianSalary();
                     break;
            case 5:  roles = getRepository().listAllByMedianChange();
                     break;
            case 6:  roles = getRepository().listAllByHistoricalAds();
                     break;
            case 7:  roles = getRepository().listAllByAdPercentage();
                     break;
            case 8:  roles = getRepository().listAllByLiveVacancies();
                     break;
        }
        return roles;
       }
}