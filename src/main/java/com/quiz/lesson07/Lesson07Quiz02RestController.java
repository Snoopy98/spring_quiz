package com.quiz.lesson07;

import java.util.List;
import java.util.concurrent.RecursiveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.dao.RecruitRepository;
import com.quiz.lesson07.entity.RecruitEntity;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {
	@Autowired
	private RecruitRepository recruitRepository;
	
	
	@GetMapping("/1")
	public List<RecruitEntity> getCompanyList() {
		// 1) 
//		return recruitRepository.findById(8);
		
		//2
//		return recruitRepository.findByCompanyId(1);
		
		//3
//		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		//4
		return recruitRepository.findByTypeAndSalaryGreaterThanEqual("정규직",9000);
		
		// 5
		//return recruitRepository.findTop3ByOrderBySalaryDesc();
		
		//6
//		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구" , 7000,8500);
		
		//7
//		return recruitRepository.findByType("정규직");
	}
}
