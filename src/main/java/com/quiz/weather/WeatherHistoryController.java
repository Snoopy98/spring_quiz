package com.quiz.weather;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather.bo.WeatherHistoryBO;
import com.quiz.weather.domain.WeatherHistory;
@Controller
public class WeatherHistoryController {
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 목록화면
	@GetMapping("/weather")
	public String weather(Model model) {
		List<WeatherHistory> weather = weatherHistoryBO.getWheatherHistoryList();
		model.addAttribute("weather",weather);
		
		return "weather/weatherHistory";
	}
	// 추가화면
	@GetMapping("/addWeather")
	public String addWeatherView() {
		return "weather/addWeather";
	}
	
	// 날씨 insert
	@PostMapping("/add_Weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		// insert db
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
	return "redirect:/weather"; // 새 request
	}
}
