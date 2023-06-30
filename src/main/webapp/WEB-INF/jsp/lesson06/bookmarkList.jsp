<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
</head>
<body>

	<div class="container">
	<h1>즐겨찾기 목록</h1>

		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${sites}" var="site" varStatus="status">
				<tr>
					<td>${site.id}</td>
					<td>${site.name}</td>
					<td>${site.url}</td>
					<!-- //1) name 속성과 value 속성을 이용하여 동적으로 삭제버튼 값 가져오기 -->
				 <%-- <td><button tpye="button" name="delBtn " class="btn btn-danger" value="${site.id}">삭제</button></td> --%>
				 
				 <!-- 2) data 를 이용해서 태그에 값을 임시 저장해놓기  -->
				 <td><button tpye="button" name="delBtn " class="del-btn btn btn-danger" data-bookmark-id="${site.id}">삭제</button></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	$(document).ready(function(){
		//1) name 속성과 value 속성을 이용하여 동적으로 삭제버튼 값 가져오기
		///* $('button[name=delBtn]').on('click',function(e){
	//	/* alert("삭제버튼");	
		//let id = $(this).val();
		
		//let id= $(this).attr('value');
		//let id = e.target.value
		
		// 2) data 를 이용해서 태그에 값을 임시 저장해놓기 
		// 태그영역 : data-bookmark-id   data- 그뒤부터는 우리가 이름을 짓는다 카멜케이스 절대안됨 소문자만 ㄱ
		// 스크립트 영역 : $(this).data('bookmark-id');
		$('.del-btn').on('click',function(){
			//alert("삭제");
			
			let id = $(this).data('bookmark-id');
			//alert(id);
			$.ajax({
			//request
			type:"delete"
			,url:"/lesson06/quiz01/delete_site"
			,data{"siteId":id}
			//response
			,success:function(data){
				if(data.code == 1){ // 성공
					location.reload(true); // 그자리에서 새로고침
					}else{
					alert(data.errorMessage);	
					}
			}
			,error:function(request,status,error){
				alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
			}
			});
			
		});
		
		
	});
	</script>
</body>
</html>