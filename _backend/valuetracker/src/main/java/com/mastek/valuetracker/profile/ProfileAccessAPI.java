package com.mastek.valuetracker.profile;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastek.valuetracker.profile.Profile;
import com.mastek.valuetracker.profile.ProfileJPARepository;
import com.mastek.valuetracker.role.Role;
import com.mastek.valuetracker.role.RoleJPARepository;

@Component
@Path("/profiles")
public class ProfileAccessAPI {
	
	
	ProfileJPARepository repository;
	RoleJPARepository roleRepository;
	
    public ProfileJPARepository getRepository() {
        return repository;
    }
    @Autowired
    public void setRepository(ProfileJPARepository repository) {
        this.repository = repository;
    }
    
    
    public RoleJPARepository getRoleRepository() {
        return roleRepository;
    }
    @Autowired
    public void setRoleRepository(RoleJPARepository repository) {
        this.roleRepository = repository;
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
    
	@POST
	@Path("/role/add")
	@Transactional
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Role addSkillToProfile(@BeanParam Registration reg) {
		System.out.println(reg + " " + reg.getRoleId());
		Role r = getRoleRepository().findById(reg.getRoleId()).get();
		Profile p = getRepository().findById(reg.getProfileId()).get();
		if (!p.getRoles().contains(r)) {
			p.getRoles().add(r);
		}
		getRepository().save(p);
		return r;
	}
	
	@GET
	@Path("/{profileId}/roles")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Transactional
	public Set<Role> getPersons(@PathParam("profileId") int profileId){
		Profile p = getRepository().findById(profileId).get();
		if (!p.getRoles().isEmpty()) {
			return p.getRoles();
		}
		return null;
	}
}
