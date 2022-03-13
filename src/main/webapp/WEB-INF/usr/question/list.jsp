<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 자카르타에서 jsp를 사용하려면 주입 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 리스트</title>
</head>
<body>

	<h1>질문 리스트</h1>
	
	<c:foreach var="question" items="${questions}">
	
	<div class="">
		<p>제목 : ${question.title}</p>
		<p>내용 : ${question.body}</p>
	</div>
	
	</c:foreach>

</body>
</html>