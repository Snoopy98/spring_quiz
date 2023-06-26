package com.quiz.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.weather.bo.WeatherHistoryBO;
import com.quiz.weather.domain.WeatherHistory;
@Controller
public class WeatherHistoryController {
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather")
	public String weather(Model model) {
		List<WeatherHistory> weather = weatherHistoryBO.getWheatherHistory();
		model.addAttribute("weather",weather);
		
		return "weather/weatherHistory";
	}
	
	@GetMapping("/addWeather")
	public String addWeather() {
		return "weather/addWeather";
	}
	
	@PostMapping("/afterWeather")
	public String afterWeather(WeatherHistory weather) {
		
	return"redirect:/weather";
	}
}
