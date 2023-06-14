package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring bean
@RequestMapping("/lesson01/quiz01")

public class Quiz01 {
	//http://localhost:8080/lesson01/quiz01/1
	@RequestMapping("/1")
	
	public @ResponseBody String text() {
		
				
		return "<h1>테스트 프로젝트 완성</h1><h3>해당 프로젝트를 통해서 문제풀이를 진행합니다.</h3>";
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> subject(){
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		return map;
	}
	
}
