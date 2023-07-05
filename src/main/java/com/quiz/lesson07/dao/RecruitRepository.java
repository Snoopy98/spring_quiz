package com.quiz.lesson07.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	public List<RecruitEntity> findById(int id);
	public List<RecruitEntity> findByCompanyId(int id);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	

}
