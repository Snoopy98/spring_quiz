package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.RelatorMapper;
import com.quiz.lesson04.domain.Relator;

@Service
public class RelatorBO {
	@Autowired
	private RelatorMapper relatorMapper;
	
	public void addRelator(Relator relator) {
		 relatorMapper.insertRelator(relator);
}
	
	public Relator getRelatorById(int id) {
		return relatorMapper.selectRelatorById(id) ;
	}
}
