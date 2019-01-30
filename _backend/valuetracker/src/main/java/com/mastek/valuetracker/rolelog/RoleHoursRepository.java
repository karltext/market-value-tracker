package com.mastek.valuetracker.rolelog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface RoleHoursRepository extends CrudRepository<RoleHours, Integer>{
	
	

}
