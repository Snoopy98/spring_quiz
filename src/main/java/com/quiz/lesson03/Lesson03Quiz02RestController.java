package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;


public class Lesson03Quiz02RestController {
@Autowired
private RealEstateBO realEstateBO;
//http://localhost:8080/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int successRow = realEstateBO.addRealEstate(realEstate);
				return "입력 성공:" + successRow;
	}
	
	@RequestMapping("/2")
	public String quiz02_2(@RequestParam("realtor_id") int realtorId) {
		
		int row = realEstateBO.addRealEstateAsField(realtorId,"썅떼빌리버 오피스텔 814호",45,"월세",100000,120);
		return "입력 성공:" + row;
	}
	
	
	@RequestMapping("/lesson03/quiz03")
	public String quiz03(
			@RequestParam("id") int id,
			@RequestParam("type") String type,
			@RequestParam("price") int price) {
		
		int row = realEstateBO.updateRealEstateById(id, type ,price);
		return "수정 성공:" + row;
	}
	
	
	
	
}
