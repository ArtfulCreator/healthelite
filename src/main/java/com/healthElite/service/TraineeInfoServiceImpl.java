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

import com.healthElite.model.TraineeInfo;
import com.healthElite.model.Login;
import com.healthElite.model.PlanInfo;
import com.healthElite.repository.TraineeInfoRepository;
import com.healthElite.repository.LoginRepository;
import com.healthElite.repository.PlanInfoRepository;

@Service("traineeInfoService")
public class TraineeInfoServiceImpl{
	
	@Autowired
	private TraineeInfoRepository traineeInfoRepository; 

	@Transactional
	public TraineeInfo save(TraineeInfo traineeInfo) {
		return traineeInfoRepository.save(traineeInfo);
	}
	
	public Page<TraineeInfo> findAll(Pageable pageable) {
		return traineeInfoRepository.findAll(pageable);
	}
	
	public List<TraineeInfo> findAll() {
		
		final PageRequest page1 = new PageRequest(
				  0, 20, Direction.ASC, "traineeInfoId"
				);
		return findAll(page1).getContent();
	}
	
	@Transactional
	public TraineeInfo findTraineeInfoByTraineeInfoId (Integer traineeInfoId) {
		return traineeInfoRepository.findByTraineeInfoId(traineeInfoId);
	}
	
	@Transactional
	public List <TraineeInfo> findByLastNameOrFirstNameLike (String name) {

		return traineeInfoRepository.findByFirstNameOrLastNameLike(name);
		
	}
	
	@Transactional
	public TraineeInfo findByUserName (String userName) {
		
		return traineeInfoRepository.findTraineeInfoByUserName(userName);
		
	}
	

	
}
