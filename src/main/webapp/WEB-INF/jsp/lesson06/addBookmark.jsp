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
	<input type="text" id="domain" class="form-control">
	<div class="my-2">주소</div>
	<input type="text" id="url" class="form-control">
	<input type="button" class="btn btn-success w-100 my-3" value="추가" id="addBtn">
	
	</div>
	
	<script>
	$(document).ready(function(){
		$('#addBtn').on('click',function(){
			//alert("클릭");
			//validation
			let domain = $('#domain').val().trim();
			let url = $('#url').val().trim();
			
			if(domain == ""){
				alert("사이트명을 입력해주세요");
				return;
			}
			if(url == ""){
				alert("사이트 주소를 입력해주세요");
				return;
			} 
			
			if(url.startsWith('http') == false ){
			alert("주소는 http 나 https 로 시작해주세요");
			return;
			}
		});
		
		$ajax.({
			//request
			type:"post"
			,url:"/lesson06/quiz01/add_site" // 절대로 view 가 붙지 않는다. 
			,data:{"domain":domain,"url":url}
			
			//response
			,success:function(data){
				if(data == "성공"){
					location.href = "/lesson06/quiz01/site_view"
				}
			}
			,error:function(request, status, error){
				alert(request);
				alert(status);
				alert(error);
			
		});
		
	})
	
	</script>
</body>
</html>