package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson01/quiz02")
public class Quiz02 {

//	http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>() {
			{
				put("rate", 15);
				put("director", "봉준호");
				put("time", 131);
				put("title", "기생충");
			}
		};
		list.add(map);

		map = new HashMap<>() {
			{
				put("rate", 0);
				put("director", "로베르토 베니니");
				put("time", 116);
				put("title", "인생은 아름다워");
			}
		};
		list.add(map);
		map = new HashMap<>() {
			{
				put("rate", 12);
				put("director", "크리스토퍼 놀란");
				put("time", 167);
				put("title", "인셉션");
			}
		};
		list.add(map);
		map = new HashMap<>() {
			{
				put("rate", 19);
				put("director", "윤종빈");
				put("time", 133);
				put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
			}
		};
		list.add(map);
		map = new HashMap<>() {
			{
				put("rate", 15);
				put("director", "프란시스 로렌스");
				put("time", 137);
				put("title", "헝거게임");
			}
		};
		list.add(map);

		return list;
	}
	
	//	http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		//@ResponseBody + return String => HttpMessageConverter    HTML
		//@ResponseBody + return 객체 => HttpMessageConverter jackson 라이브러리  => JSON string
		
		List<Board> resultList = new ArrayList<>();
		Board board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("haguru");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부타드립니다. 활동 열심히 하겠습니다.");
		resultList.add(board);
		
		 board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("bada");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부타드립니다. 활동 열심히 하겠습니다.");
		resultList.add(board);
		
		 board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("dulumary");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부타드립니다. 활동 열심히 하겠습니다.");
		resultList.add(board);
		return resultList;
	}
	//	http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Board> ex01_7() {
		Board board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("haguru");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부타드립니다. 활동 열심히 하겠습니다.");
		return new ResponseEntity<>(board,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
