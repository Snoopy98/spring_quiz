package com.quiz.weather.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather.dao.WeatherHistoryMapper;
import com.quiz.weather.domain.WeatherHistory;

@Service
public class WeatherHistoryBO {
@Autowired
private WeatherHistoryMapper weatherHistoryMapper;
	public List<WeatherHistory> getWheatherHistory(){
		return weatherHistoryMapper.selectWheatherHistory();
	}
	
	 
	public void addWeatherHistory(String date,String weather,String microDust,double temperature,
			double precipitation, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, microDust, temperature, precipitation, windSpeed);
	}
}
