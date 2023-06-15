package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.domain.Store;
@Service // Spring bean
public class StoreBO {
	@Autowired 
	private StoreMapper storeMapper; // Spring bean 을 주입받는다. DI
	// input: X   
	// output: List<Store>  Controller 한테
		public List<Store> getStoreList(){
			
			return storeMapper.selectStoreList();
		}
}
