<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 정보</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
<h1>멤버십</h1>
	<table class="table">
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>등급</th>
				<th>포인트</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${membership}" var="membership" varStatus="status">

			<tr>
				<td>${membership.name}</td>
				<td>${membership.phoneNumber}</td>
				
				<c:choose>
				<c:when test="${membership.grade eq 'VIP'}"><td class="text-danger">${membership.grade}</td></c:when>
				<c:when test="${membership.grade eq 'GOLD'}"><td class="text-warning">${membership.grade}</td></c:when>
				<c:otherwise><td>${membership.grade}</td></c:otherwise>
				</c:choose>	
				
				<c:choose>
				<c:when test="${membership.point >= 5000 }"><td class="text-primary">${membership.point}</td></c:when>
				<c:otherwise><td>${membership.point}</td></c:otherwise>
				</c:choose>
			</tr>
			
			
			
	</c:forEach>	
		</tbody>
	</table>
</body>
</html>