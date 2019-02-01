package com.mastek.valuetracker.rolelog;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


@Component
public interface RoleHoursRepository extends CrudRepository<RoleHours, Integer>{
		
	@Query(value="SELECT `median_salary` FROM `vt_role` t WHERE t.skill = :skill", nativeQuery=true)
	public List<Double> findByRole(@Param("skill") String skill);

}
