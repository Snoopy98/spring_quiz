package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {
	@Autowired
	private CompanyBO companyBO;
		@GetMapping("/save1")
		public CompanyEntity save1() {
			
		return companyBO.addCompany("넥손", "컨텐츠 게임", "대기업", "3585명");
			
		}
		@GetMapping("/save2")
		public CompanyEntity save2() {
			return companyBO.addCompany("버블팡", "여신 금융업", "대기업", "6834명");
		}
		
//		 "id": 8,
//		  "name": "버블팡",
//		  "business": "여신 금융업",
//		  "scale": "중소기업",
		@GetMapping("/update")
		public CompanyEntity update() {
			CompanyEntity company = companyBO.updateCompanyById(7, "중소기업", "34명");
			return company;
		}
}
