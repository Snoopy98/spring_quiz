package com.quiz.weather.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.weather.domain.WeatherHistory;
@Repository
public interface WeatherHistoryMapper {

	
	public List<WeatherHistory> selectWheatherHistory();
	
	public void insertWeatherHistory(
			@Param("date") String date,
			@Param("weather") String weather,
			@Param("microDust") String microDust,
			@Param("temperature") double temperature,
			@Param("precipitation") double precipitation,
			@Param("windSpeed") double windSpeed);
}
