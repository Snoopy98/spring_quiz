package com.quiz.lesson07.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	public List<RecruitEntity> findById(int id);
	public List<RecruitEntity> findByCompanyId(int id);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region,int salary1,int salary2);
	// native query => DB 쿼리문으로 직접 수행
	@Query(value = "select * from recruit where type = :type and salary >= :salary and deadline > :deadline order by salary desc" ,nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAfterAndSalaryAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline,
			@Param("salary") int salary,
			@Param("type") String type);

}
