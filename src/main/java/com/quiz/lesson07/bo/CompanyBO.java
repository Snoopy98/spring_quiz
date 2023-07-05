package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.dao.CompanyRepository;
import com.quiz.lesson07.entity.CompanyEntity;

@Service
public class CompanyBO {
	@Autowired
	private CompanyRepository companyRepository;
	
	
	public CompanyEntity addCompany(String name , String business, String scale, String headcount) {
		CompanyEntity company = companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build()
				); 
		return company;
	}
	// input : id , scale , headcount   
	// output : CompanyEntity
	public CompanyEntity updateCompanyById(int id ,String scale, String headcount) {
		// select
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		// update
		if(company != null) {
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build(); 
			company = companyRepository.save(company);
		}
		return company;
	}
	
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
}
