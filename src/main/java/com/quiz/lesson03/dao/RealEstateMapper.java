package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;
@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(@Param("id") int id); // @Param: 파람안에 넣는 명으로 xml에 사용된다. 생략 가능하지만 두개 이상일때는 필수 
	
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate>  selectRealEstateByAreaPrice(@Param("area") int area,@Param("price") int price);
	
}
