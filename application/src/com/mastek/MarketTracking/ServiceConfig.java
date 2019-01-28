package com.mastek.MarketTracking;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig extends ResourceConfig {

	public ServiceConfig() {
		
		//register the CORS Filter for service
		//register(CORSFilter.class);
		//register the class as a service
		
		register(RoleAccessAPI.class);
	}
}
	