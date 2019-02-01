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

@Component
@Path("/profiles")
public class ProfileAccessAPI {
	
	
	ProfileJPARepository repository;
	SkillJPARepository skillRepository;
	
    public ProfileJPARepository getRepository() {
        return repository;
    }
    @Autowired
    public void setRepository(ProfileJPARepository repository) {
        this.repository = repository;
    }
    
    
    public SkillJPARepository getSkillRepository() {
        return skillRepository;
    }
    @Autowired
    public void setSkillRepository(SkillJPARepository repository) {
        this.skillRepository = repository;
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
    @Path("/skill/register")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Skill registerProfile(@BeanParam Skill s) {
        return getSkillRepository().save(s);
    }
   
	@POST
	@Path("/skill/add")
	@Transactional
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Skill addSkillToProfile(@BeanParam Registration r) {
		System.out.println("x" + r);
		Skill s = getSkillRepository().findById(r.getSkillId()).get();
		Profile p = getRepository().findById(r.getProfileId()).get();
		if (!p.getSkills().contains(s)) {
			p.getSkills().add(s);
		}
		getRepository().save(p);
		return s;
	}
	
	@GET
	@Path("/{profileId}/skills")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Transactional
	public Set<Skill> getPersons(@PathParam("profileId") int profileId){
		Profile p = getRepository().findById(profileId).get();
		if (!p.getSkills().isEmpty()) {
			return p.getSkills();
		}
		return null;
	}
}
