package com.mastek.valuetracker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleJPARepository extends CrudRepository<Role,Integer>{
}