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
	
	//input : real_estate
	// output: 입력성공 1
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	public int addRealEstateAsField(int realtorId, String address, int area, 
			String type, int price , Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstateById(int id ,String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	public void deleteRealEstateById(int id) {
		realEstateMapper.deleteRealEstateById(id);
	}
}
