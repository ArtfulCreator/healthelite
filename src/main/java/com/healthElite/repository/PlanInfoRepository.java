package com.healthElite.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthElite.model.PlanInfo;


@Repository
public interface PlanInfoRepository extends CrudRepository<PlanInfo, Integer> {
	
	   @Query
	   PlanInfo findByPlanInfoId(Integer planInfoId);
	   
	   @Query
	   Page<PlanInfo> findAll(Pageable pageable);
	   
	   @Query
	   Page<PlanInfo> findByNameLike(String name, Pageable pageable);
	   
	   @Query
	   PlanInfo findPlanInfoByPlanInfoId(Integer planInfoId);

}
