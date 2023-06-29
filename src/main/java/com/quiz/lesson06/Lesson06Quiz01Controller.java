package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.SiteBO;
import com.quiz.lesson06.domain.Site;
@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private SiteBO siteBO;
	
	
	// 즐겨찾기 목록 
	@GetMapping("/site_view")
	public String site(Model model) {
		
		// select db
		List<Site> sites = siteBO.getSiteList();
		model.addAttribute("sites",sites);
		return "lesson06/bookmarkList";
	}
	// 즐겨찾기 추가 
	@GetMapping("/add_site_view")
	public String addSiteView() {
		return "lesson06/addBookmark";
	}
	
	// AJAX 
	@PostMapping("/add_site")
	@ResponseBody
	public Map<String, Object> addSite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		//db insert
		siteBO.addSite(name, url);
		
		// 응답
		//{"code":1, "result":"성공"} JSON String
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		
		return result;
	}
	
	// AJAX
	
	
	
}
