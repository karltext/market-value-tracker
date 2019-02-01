package com.mastek.valuetracker.rolelog;

import java.util.List;

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
@Path("/team")
public class TeamAPI {

		TeamJPARepository repository;
		
		public TeamJPARepository getRepository() {
	        return repository;
	    }
	    @Autowired
	    public void setRepository(TeamJPARepository repository) {
	        this.repository = repository;
	    }
	
	    @Path("/list")
		@GET
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Iterable<TeamMember> listRoles() {
			return getRepository().findAll();
		}
	    
	    @Path("/register")
	    @POST
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	    public TeamMember addTeamMember() {
	    	TeamMember member = new TeamMember();
	    	member.setRoleName("Developer");
	    	member.setSalary(54000);
	    	member.setHourlySalary((member.getSalary()/52)/40);
	    	getRepository().save(member);
	    	return member;
	    }
	    
	    @Path("/registerPJ")
	    @POST
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	    public TeamMember addTeamMemberPJ() {
	    	TeamMember member = new TeamMember();
	    	member.setRoleName("Project Manager");
	    	member.setSalary(84000);
	    	member.setHourlySalary((member.getSalary()/52)/40);
	    	getRepository().save(member);
	    	return member;
	    }
	    
	    
	    @DELETE
		@Path("/delete")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public TeamMember deleteTeamMember(int roleId) {
			TeamMember deleteTeamMember = getRepository().findById(roleId).get();
			getRepository().delete(deleteTeamMember);
			return deleteTeamMember;
		}
	    
	    @DELETE
		@Path("/deleteAll")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public TeamMember deleteAll(int roleId) {
			TeamMember deleteTeamMember = getRepository().findById(roleId).get();
			getRepository().deleteAll();
			return deleteTeamMember;
		}
	    
	
	
}
