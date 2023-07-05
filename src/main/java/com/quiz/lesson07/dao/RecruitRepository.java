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
	public List<RecruitEntity> findTop3ByOrderBySalaryDesc();
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region,int salary1,int salary2);
	
	@Query(value = "select * from recruit where type = :type and salary >= 8100 and deadline > 2026-04-10 order by salary desc" ,nativeQuery = true)
	public List<RecruitEntity> findByType(@Param("type") String type);
	// native query => DB 쿼리문으로 직접 수행
//		//@Query(value = "select * from new_student where dreamJob=:dreamJob", nativeQuery = true)
//		@Query(value = "select st from new_student st where st.dreamJob = :dreamJob")
//		public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);

	public List<RecruitEntity> findByTypeAndSalaryGreaterThanEqual(String type, int salary);
}
