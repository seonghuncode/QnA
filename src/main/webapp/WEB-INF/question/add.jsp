<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문하기</title>
</head>
<body>
	<div>
		<h1>질문하기</h1>
	</div>
	
	<div>
		<form action="/question/q/add" method="post">
		<div>
			<input type = "text"name="title" />
		</div>
		<div>
			<input type = "text"name="body"/>
		</div>
		<div>
			<button type="submit"질문하기> </button>
			<button type="button" 취소> </button>
		</div>
		</form>>
	</div>
	
</body>
</html>