<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container ">
	
	<h1>즐겨찾기 추가하기</h1>
	
	
	<div class="my-2">제목</div>
	<input type="text" id="name" class="form-control">
	<div class="my-2">주소</div>
	<div class="d-flex">
			<input type="text" id="url" class="form-control col-9">
			<button type="button" id="duplicationBtn" class="btn btn-info mx-5">중복확인</button>
	</div>
	<small id="duplicationTextArea" class="text-danger d-none">중복된 url 입니다.</small>	
	<small id="availableTextArea" class="text-success d-none">저장 가능한 url 입니다.</small>	
		
	<input type="button" class="btn btn-success w-100 mt-5" value="추가" id="addBtn">
	</div>
	<script>
	$(document).ready(function(){
		
		// 중복확인 버튼 클릭 이벤트
		$('#duplicationBtn').on('click', function(){
			//alert("클릭");
			let url = $('#url').val().trim();
			$('#duplicationTextArea').empty();
			//validation
			if(url == ""){
				alert("검사할 url 을 입력해주세요.")
				return;
			}	
			
			// AJAX 통신 => 디비에 있는지 확인
			$.ajax({
				//request
				type:"post"
				,url:"/lesson06/quiz01/is_duplication_url"
				,data{"url":url}
			
				//response
				,success:function(data){
					//{"code":1,"isDuplication":true}
					if(data.isDuplication){// 중복
						$('#duplicationTextArea').removeClass('d-none');
						$('#availableTextArea').addClass('d-none');
					}else{// 사용 가능 (중복아님)
						$('#duplicationTextArea').addClass('d-none');
						$('#availableTextArea').removeClass('d-none');
					}
				}
			});
			
		});
		
		// 추가 버튼 클릭 이벤트
		$('#addBtn').on('click',function(){
			//alert("클릭");
			
			let name = $('#name').val().trim();
			
			//validation
			if(name == ""){
				alert("제목을 입력해주세요")
				return;
			}
			if(url == ""){
				alert("주소를 입력해주세요")
				return;
			}
			if(url.startsWith("http") == false && url.startsWith("https") == false) {
				alert("주소는 http나 https 로 시작해야합니다.")
				return ;
			}
			// 중복확인 테스트
			if($('#availableTextArea').hasClass('d-none'))){
				alert("중복된 url 입니다. 다시 확인해주세요");
				return;
			}
		$.ajax({
			// request
			type:"post"
			,url:"/lesson06/quiz01/add_site" // 절대로 view 가 붙지 않는다. 
			,data:{"name":name,"url":url}
			
			//response
			,success:function(data){ // String, JSON 자바 스크립트의 객체 변환
				/* alert(data.code);
				alert(data.result); */
				if(data.result == "성공"){
					location.href = "/lesson06/quiz01/site_view"; // Get method
				}
			}
			,error:function(request, status, error){
				alert("즐겨찾기이 실패하셧습니다.")
			}
		});
	});

	});
	</script>
</body>
</html>