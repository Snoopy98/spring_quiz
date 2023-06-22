package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RelatorBO;
import com.quiz.lesson04.domain.Relator;
@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	@Autowired
	private RelatorBO relatorBO;
	
	
	
//	http://localhost/lesson04/quiz02/add_realtor_view
	 @GetMapping("/add_realtor_view")
	 public String addRealtorView() {
		 return "lesson04/addRealtor";
	 }
	 
	 //http://localhost/lesson04/quiz02/add_realtor
	 @PostMapping("/add_realtor")
	 public String addRelator(
			 @ModelAttribute Relator relator, Model model) {
		 
		 // insert db
		 relatorBO.addRelator(relator);
		 
		 //select db 늦은 데이터 페이지 
		 Relator latestRelator = relatorBO.getRelatorById(relator.getId());
		 model.addAttribute("result",latestRelator);
		 
		 return "lesson04/afterAddRelator";
	 }
}
