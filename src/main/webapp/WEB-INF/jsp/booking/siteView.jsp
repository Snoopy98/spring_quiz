<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<style>
.nav{background-color:#DF7401;}
.nav-link{color:white;}
</style>
</head>
<body>
<div class="container" id="wrap">
	<!-- 헤더 영역 -->
	<header>
	<h1 class="text-center">통나무 펜션</h1>
	<nav class="nav-fill" >
	<ul class="nav bg">
		<li class="nav-item"><a class="nav-link">펜션소개</a></li>
		<li class="nav-item"><a class="nav-link">객실보기</a></li>
		<li class="nav-item"><a class="nav-link">예약하기</a></li>
		<li class="nav-item"><a class="nav-link">예약목록</a></li>
	</ul>
	</nav>
	</header>
	<!-- 콘텐츠 영역 -->
	<h3 class="text-center my-3 font-weight-bold">예약 목록 보기</h3>
	<section>
	<table class="table">
		<thead>
			<tr>
				<th>이름</th>
				<th>예약날짜</th>
				<th>숙박일수</th>
				<th>숙박인원</th>
				<th>전화번호</th>
				<th>예약상태</th>
				<th></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${bookingList}" var="booking">
			<tr>
				<td>${booking.name}</td>
				<td>
				<fmt:parseDate value="${booking.date}" pattern="yyyy-M-dd" var="date"/>
				<fmt:formatDate value="${date}" pattern="yyyy년 M월 dd일" /> 
				</td>
				<td>${booking.day}</td>
				<td>${booking.headcount}</td>
				<td>${booking.phoneNumber}</td>
				<td>
				<c:choose>
					<c:when test="${booking.state eq '대기중'}">
						<span class="text-primary">${booking.state}</span>
					</c:when>
					<c:when test="${booking.state eq '확정'}">
						<span class="text-success">${booking.state}</span>
					</c:when>
				</c:choose>
				</td>
				<!-- 삭제 버튼  -->
				<td>
				<button type="button" class="btn btn-danger">삭제</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</section>
	<footer></footer>



</div>
</body>
</html>