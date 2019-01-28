package com.example.MarketSystem;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.MarketSystem.MarketTrackerAPI;

@Component
public class ServiceConfig extends ResourceConfig{
	
	public ServiceConfig() {
		// register the CORS Filter for Service
		register(CORSFilter.class);
		// register the class as a Service
		register(MarketTrackerAPI.class);
		
	}

}
