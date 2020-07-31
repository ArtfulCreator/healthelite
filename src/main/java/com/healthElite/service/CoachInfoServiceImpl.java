package com.healthElite.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthElite.model.CoachInfo;
import com.healthElite.model.Login;
import com.healthElite.model.PlanInfo;
import com.healthElite.repository.CoachInfoRepository;
import com.healthElite.repository.LoginRepository;
import com.healthElite.repository.PlanInfoRepository;

@Service("coachInfoService")
public class CoachInfoServiceImpl{
	
	@Autowired
	private CoachInfoRepository coachInfoRepository; 

	@Transactional
	public CoachInfo save(CoachInfo coachInfo) {
		return coachInfoRepository.save(coachInfo);
	}
	
	public Page<CoachInfo> findAll(Pageable pageable) {
		return coachInfoRepository.findAll(pageable);
	}
	
	public List<CoachInfo> findAll() {
		
		final PageRequest page1 = new PageRequest(
				  0, 20, Direction.ASC, "coachInfoId"
				);
		return findAll(page1).getContent();
	}
	
	@Transactional
	public CoachInfo findCoachInfoByCoachInfoId (Integer coachInfoId) {
		return coachInfoRepository.findByCoachInfoId(coachInfoId);
	}
	
	@Transactional
	public List <CoachInfo> findByLastNameOrFirstNameLike (String name) {

		return coachInfoRepository.findByFirstNameOrLastNameLike(name);
		
	}
	
	@Transactional
	public CoachInfo findByUserName (String userName) {
		
		return coachInfoRepository.findCoachInfoByUserName(userName);
		
	}
	

	
}
