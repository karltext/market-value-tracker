package com.mastek.valuetracker.profile;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.valuetracker.profile.Profile;
import com.mastek.valuetracker.profile.ProfileJPARepository;
import com.mastek.valuetracker.role.Role;

@Component
@Path("/profiles")
public class ProfileAccessAPI {
	
	
	ProfileJPARepository repository;
	
    public ProfileJPARepository getRepository() {
        return repository;
    }
    @Autowired
    public void setRepository(ProfileJPARepository repository) {
        this.repository = repository;
    }
    
   	@GET
    @Path("/find")
   	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Profile findById(@QueryParam("profileId") int id) {
    	return getRepository().findById(id).get(); 
    }
    
    @GET
    @Path("/list")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Profile> listProfiles() {
		return getRepository().findAll();
    }
    
    @POST
    @Path("/register")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Profile registerProfile(@BeanParam Profile p) {
        return getRepository().save(p);
    }
}
