package com.healthElite.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthElite.model.CoachInfo;
import com.healthElite.model.Login;
import com.healthElite.model.PlanInfo;

@Repository
public interface CoachInfoRepository extends CrudRepository<CoachInfo, Integer> {
	

	   CoachInfo findByCoachInfoId( Integer coachInfoId);
	   
	   Page<CoachInfo> findAll(Pageable pageable);
	   
	   @Query("select coachInfo from CoachInfo coachInfo where coachInfo.roles.login.firstName like :name or coachInfo.roles.login.lastName like :name")
	   List <CoachInfo> findByFirstNameOrLastNameLike(@Param("name") String name); 
	   
	   @Query("select coachInfo from CoachInfo coachInfo where coachInfo.roles.login.userName = :userName")
	   CoachInfo findCoachInfoByUserName(@Param("userName") String userName);


}
