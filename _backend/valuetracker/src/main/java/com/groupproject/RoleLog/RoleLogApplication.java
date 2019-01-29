package com.groupproject.RoleLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class RoleLogApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= 
				SpringApplication.run(RoleLogApplication.class, args);
		/*
		RoleHoursAPI rolehrsAPI = ctx.getBean(RoleHoursAPI.class);
		RoleHours newRoleHours = new RoleHours();
		newRoleHours.setRole("JAVA");
		newRoleHours.setHours(9);
		
		
		rolehrsAPI.addRoleHours(newRoleHours);
		
		ctx.close();
		*/
	}

}

