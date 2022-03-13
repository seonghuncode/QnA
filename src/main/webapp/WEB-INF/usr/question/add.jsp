<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문하기</title>
</head>
<body>
	<div class="">
		<h1>질문하기</h1>
	</div>
	
	<div class="question-form-container">
	
		<form action="/qna/questions/add" method="POST">
		
		<div>
			<input type = "text" name="title" placeholder="질문 제목을 입력해 주세요"/>
		</div>
		
		<div>
			<input type = "text" name="body" placeholder ="질문 내용을 입력해 주세요" />
		</div>
		
		<div class="">
			<button>질문하기 </button> <!-- 타입을 안적어 주어도 된다. -->
			<button type="button"> 취소 </button>
		</div>
		
		</form>
	</div>
	
</body>
</html>


