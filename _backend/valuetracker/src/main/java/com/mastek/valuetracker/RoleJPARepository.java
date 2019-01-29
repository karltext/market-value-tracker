package com.mastek.valuetracker;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoleJPARepository extends CrudRepository<Role,Integer>{
	
	 @Query(value = "SELECT * FROM `roles` t WHERE t.skill LIKE CONCAT('%',:skill, '%')",nativeQuery = true)
	    public List<Role> findByRole(@Param("skill")String skill);
}