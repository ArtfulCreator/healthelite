package com.healthElite.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthElite.model.TraineeInfo;


@Repository
public interface TraineeInfoRepository extends CrudRepository<TraineeInfo, Integer> {
	
	   @Query
	   TraineeInfo findByTraineeInfoId( Integer traineeInfoId);
	   
	   @Query
	   Page<TraineeInfo> findAll(Pageable pageable);
	   
	   @Query("select traineeInfo from TraineeInfo traineeInfo where traineeInfo.roles.login.firstName like :name or traineeInfo.roles.login.lastName like :name")
	   List <TraineeInfo> findByFirstNameOrLastNameLike(@Param("name") String name); 
	   
	   @Query("select traineeInfo from TraineeInfo traineeInfo where traineeInfo.roles.login.userName = :userName")
	   TraineeInfo findTraineeInfoByUserName(@Param("userName") String userName);


}
