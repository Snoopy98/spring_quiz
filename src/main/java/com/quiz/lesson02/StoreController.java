package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.NewReviewBO;
import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.NewReview;
import com.quiz.lesson02.domain.Store;

@Controller
public class StoreController {
	@Autowired
	private StoreBO storeBO;
	private NewReviewBO newReviewBO;
	
	@GetMapping("/store_view")
	public String store_view(Model model) {
		List<Store> store = storeBO.getStoreList();
		model.addAttribute("store", store);
		return "store/store";
	}
	
	@GetMapping("/reviews")
	public String reviews(
		@RequestParam("storeName") String storeName,
		@RequestParam("storeId") int id	,
		Model model) {
		//select db
		List<NewReview> reviews = newReviewBO.getNewReviewList(storeName, id);
		model.addAttribute("reviews",reviews);
		model.addAttribute("storeName",storeName);
		return "store/reviews";
	}
	
}
