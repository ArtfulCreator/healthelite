package com.healthElite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthElite.model.Login;


@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {
	   
	   @Query
	   Login findLoginByLoginId(Integer loginId);
	   



}
