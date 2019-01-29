package com.mastek.valuetracker;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig extends ResourceConfig {
    public ServiceConfig() {
        register(RoleAccessAPI.class);
        register(CORSFilter.class);
    }
}