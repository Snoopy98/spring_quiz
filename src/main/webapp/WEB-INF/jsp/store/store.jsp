<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<style>
.box{border:solid #14A0A0; width:100%; height:150px;}

</style>
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		
		<!-- 가게목록 -->
		<c:forEach items="${store}" var="storeList" >
		<div class="box p-3 my-3 form-control" style="cursor:pointer;"
		 onclick="location.href='/reviews?storeName=${storeList.name}&storeId=${storeList.id}'">
		<div><h3 class="font-weight-bold">${storeList.name}</h3></div>
		<div><h4>${storeList.phoneNumber}</h4></div>
		<div><h4>${storeList.address}</h4></div>
		</div>
		</c:forEach>
		
	</div>
</body>
</html>