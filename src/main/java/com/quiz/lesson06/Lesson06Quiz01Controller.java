package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	//AJAx 하는 요청 -> URL 중복확인
	@ResponseBody
	@PostMapping("/is_duplication_url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url){
		
		Map<String,Object> result = new HashMap<>();
		result.put("code",1);
		result.put("isDuplication",false);
		
		// db select by url
		Site site = siteBO.getSiteByUrl(url); // 사이트가 있거나 null 이거나
		if(site != null) { // 중복
			result.put("isDuplication",true);
		}
		
		
		return result;
	}
	
	// AJAX 가 하는 요청 - 즐겨찾기 삭제
	@ResponseBody
	@DeleteMapping("/delete_site")
	public Map<String, Object> delteSite(
			@RequestParam("siteId") int id){
		//db delete
		int row = siteBO.deleteSiteById(id);
		
		Map<String,Object> result = new HashMap<>();
		
		
		if(row == 1) {
			result.put("code",1);
			result.put("result","성공");
		}else {
			// 실패 (삭제)
			result.put("code",500);	
			result.put("errorMessage","삭제될 데이터가 없습니다.");
		}
		return result;
	}
	
	
}
