package com.mastek.valuetracker.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface RoleJPARepository extends CrudRepository<Role,Integer>{
	
	@Query(value="SELECT * FROM `vt_role` t WHERE t.skill LIKE CONCAT('%',:skill, '%')", nativeQuery=true)
	public List<Role> findByRole(@Param("skill") String skill);
	
	@Query(value="SELECT * FROM `vt_role` t WHERE t.skill == :skill", nativeQuery=true)
	public List<Role> findOneByRole(@Param("skill") String skill);

	@Query(value="SELECT * FROM `vt_role` r WHERE "
				+ " r.skill LIKE CONCAT('% ', :skill, ' %') "
				+ " OR r.skill LIKE CONCAT(:skill, ' %') "
				+ " OR r.skill LIKE CONCAT('% ', :skill) "
				+ " OR r.skill LIKE :skill", nativeQuery=true)
	public List<Role> findAggregateByRole(@Param("skill") String skill);
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `skill` ASC;", nativeQuery=true)
	public List<Role> listAllBySkill();
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `role_rank`;", nativeQuery=true)
	public List<Role> listAllByRank();
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `rank_change`;", nativeQuery=true)
	public List<Role> listAllByRankChange();
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `median_salary`;", nativeQuery=true)
	public List<Role> listAllByMedianSalary();
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `median_change`;", nativeQuery=true)
	public List<Role> listAllByMedianChange();
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `historical_ads`;", nativeQuery=true)
	public List<Role> listAllByHistoricalAds();
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `ad_percentage`;", nativeQuery=true)
	public List<Role> listAllByAdPercentage();
	
	@Query(value="SELECT * FROM `vt_role` ORDER BY `live_vacancies`;", nativeQuery=true)
	public List<Role> listAllByLiveVacancies();
	
	
	
}