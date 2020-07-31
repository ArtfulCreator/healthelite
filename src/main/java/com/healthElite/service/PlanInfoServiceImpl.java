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

import com.healthElite.model.PlanInfo;
import com.healthElite.repository.PlanInfoRepository;

@Service("planInfoService")
public class PlanInfoServiceImpl{
	
	@Autowired
	private PlanInfoRepository planInfoRepository; 
	


	@Transactional
	public PlanInfo save(PlanInfo planInfo) {
		return planInfoRepository.save(planInfo);
	}
	@Transactional
	public Page<PlanInfo> findAll(Pageable pageable) {
		return planInfoRepository.findAll(pageable);
	}
	
	@Transactional
	public Page<PlanInfo> findByNameLike(Pageable pageable, String name) {
		return planInfoRepository.findByNameLike(name, pageable);
	}
	
	@Transactional
	public List<PlanInfo> findByNameLike(String name) {
		
		final PageRequest page1 = new PageRequest(
				  0, 20, Direction.ASC, "name"
				);
		return findByNameLike(page1, name).getContent();
	}
	
	@Transactional
	public List<PlanInfo> findAll() {
		
		final PageRequest page1 = new PageRequest(
				  0, 20, Direction.ASC, "planInfoId"
				);
		return findAll(page1).getContent();
	}
	
	@Transactional
	public PlanInfo findPlanInfoByPlanInfoId (Integer planInfoId) {
		return planInfoRepository.findByPlanInfoId(planInfoId);
	}
}
