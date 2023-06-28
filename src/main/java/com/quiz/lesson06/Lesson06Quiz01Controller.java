package com.quiz.lesson06;

import java.util.List;

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
	@GetMapping("/site_view")
	public String site(Model model, Site site) {
		
		// select db
		List<Site> sites = siteBO.getSiteList(site);
		model.addAttribute("sites",sites);
		return "lesson06/bookmarkList";
	}
	
	@GetMapping("/add_site_view")
	public String addSiteView() {
		return "lesson06/addBookmark";
	}
	
	@PostMapping("/add_site")
	@ResponseBody
	public String addSite(
			@RequestParam("domain") String domain,
			@RequestParam("url") String url) {
		siteBO.addSite(domain, url);
		return "성공";
	}
}
