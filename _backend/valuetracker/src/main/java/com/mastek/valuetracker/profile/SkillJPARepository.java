package com.mastek.valuetracker.profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface SkillJPARepository extends CrudRepository<Skill, Integer> {
	
}