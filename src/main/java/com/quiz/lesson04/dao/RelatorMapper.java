package com.quiz.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Relator;

@Repository
public interface RelatorMapper {
		
	public void insertRelator(Relator relator);
	
	
	public Relator selectRelatorById(int id);
}
