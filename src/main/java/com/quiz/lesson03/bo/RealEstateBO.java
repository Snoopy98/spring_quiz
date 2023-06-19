package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateMapper;
import com.quiz.lesson03.domain.RealEstate;

@Service
public class RealEstateBO {
@Autowired

//input : id
//output: RealEstate => 컨트롤러한테 
	private RealEstateMapper realEstateMapper;

	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	//input : rentPrice
	// output: List<RealEstate>
	
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}
	
	//input : area,price
	//output:List<RealEstate>
	public List<RealEstate> getRealEstateByAreaPrice(int area , int price){
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}
}
