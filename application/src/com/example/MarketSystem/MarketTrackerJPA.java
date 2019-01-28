package com.example.MarketSystem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.MarketSystem.Role;

@Component
public interface MarketTrackerJPA extends CrudRepository<Role, Integer>{

}
