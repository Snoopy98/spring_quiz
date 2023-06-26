<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
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
		 <h2>날씨 입력</h1>
		 
		<form method="post" action="/weather/afterWeather">
		<div class="d-flex form-group align-items-center">
			날짜<div class="col-4"><input type="text" name="date" class="form-control"></div>
			<div class="col-4">
			<div>
			날씨<select class="form-control w-50" name="weather">
				<option>맑음</option>	
				<option>흐림</option>	
				<option>구름조금</option>	
				<option>비</option>	
			</select>
			</div>
			</div>
			<div class="col-4">
			미세먼지<select class="form-control" name="micorDust">
				<option>좋음</option>	
				<option>나쁨</option>	
				<option>보통</option>	
				<option>최악</option>	
			</select>
			</div>
		</div>
		<div class="d-flex form-group">
			<div class="input-group col-4">
 			기온 <input type="text" class="form-control" name="temperature">
			  <span class="input-group-text">°C</span>
			</div>
			<div class="input-group col-4">
 			강수량 <input type="text" class="form-control" name="precipitation">
			  <span class="input-group-text">mm</span>
			</div>
			<div class="input-group col-4">
 			풍속 <input type="text" class="form-control" name="windSpeed">
			  <span class="input-group-text">km/h</span>
			</div>
		</div>
		<div class="d-flex justify-content-end">
		<input type="submit" class="btn btn-success" value="저장">
		</div>
		</form>	 
		 </div>
		      
	</content>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>