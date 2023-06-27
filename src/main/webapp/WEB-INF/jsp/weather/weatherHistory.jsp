<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<link href="/css/weather/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container" id="wrap">
	<content class="d-flex">
		<div class="col-2 bg-info">
		<jsp:include page="menu.jsp"></jsp:include>
		<!-- 테이블 영역  -->
		 <div class="col-10">
		 <h2>과거 날씨</h1>
		 <table class="table">
		 	<thead>
		 		<tr>
		 			<th>날짜</th>
		 			<th>날씨</th>
		 			<th>기온</th>
		 			<th>강수량</th>
		 			<th>미세먼지</th>
		 			<th>풍속</th>
		 		</tr>
		 	</thead>
		 	<tbody>
		 	<c:forEach items="${weather}" var="weatherHistory">
		 		<tr>
		 			<td><fmt:formatDate value="${weatherHistory.date }" pattern="yyyy월 M월 d일" /></td>
		 			
		 			<td>
		 			<c:choose>
		 			<c:when test="${fn:contains(weatherHistory.weather,'비')}">
		 			<img src="/image/rainy.jpg" alt="비 이미지">
		 			</c:when>
		 			<c:when test="${fn:contains(weatherHistory.weather,'맑음')}">
		 			<img src="/image/sunny.jpg" alt="맑음 이미지">
		 			</c:when>
		 			<c:when test="${fn:contains(weatherHistory.weather,'구름조금')}">
		 			<img src="/image/partlyCloudy.jpg" alt="구름조금 이미지">
		 			</c:when>
		 			<c:otherwise><img src="/image/cloudy.jpg" alt="흐림 이미지"></c:otherwise>
		 			</c:choose>
		 			</td>
		 			<td>${weatherHistory.temperatures}°C</td>
		 			<td>${weatherHistory.precipitation}mm</td>
		 			<td>${weatherHistory.microDust}</td>
		 			<td>${weatherHistory.windSpeed}km/h</td>
		 		</tr>
		 	</c:forEach>	
		 	</tbody>
		 </table>
		 
		 </div>     
	</content>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>