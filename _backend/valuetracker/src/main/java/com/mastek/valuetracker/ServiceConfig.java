package com.mastek.valuetracker;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.valuetracker.profile.ProfileAccessAPI;
import com.mastek.valuetracker.CORSFilter;
import com.mastek.valuetracker.role.RoleAccessAPI;
import com.mastek.valuetracker.rolelog.RoleHoursAPI;

@Component
public class ServiceConfig extends ResourceConfig {
    public ServiceConfig() {
        register(RoleAccessAPI.class);
        register(ProfileAccessAPI.class);
        register(RoleHoursAPI.class);
        register(CORSFilter.class);
    }
}