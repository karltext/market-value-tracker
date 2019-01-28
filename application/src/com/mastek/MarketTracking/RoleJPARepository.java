package com.mastek.MarketTracking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleJPARepository extends CrudRepository<Role,Integer>{

	
	
	
}