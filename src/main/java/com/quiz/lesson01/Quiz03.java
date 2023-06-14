package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Quiz03 {
	////http://localhost:8080/lesson01/quiz03/1
		@RequestMapping("/lesson01/quiz03/1")
		public String quiz03_1() {
			//@ResponseBody 가 아닌 @Controller 인 상태로 String 을 리턴하면
			// ViewResolver 클래스에 의해 리턴된 스트링을 주소 경로로 인식
			
			
			///WEB-INF/jsp/    .jsp
			return "lesson01/quiz03";
		}
}
