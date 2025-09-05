<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/join-ok.member" method="post" name="join-form">
		<div>
			<input type="text" name="memberEmail" placeholder="이메일 입력">
		</div>
		<div>
			<input type="password" name="memberPassword" placeholder="비밀번호 입력">
		</div>
		<div>
			<input type="text" name="memberName" placeholder="이름 입력">
		</div>
		<div>
			<input type="text" name="memberAge" placeholder="나이 입력">
		</div>
		<label>
			<input type="radio" name="memberGender" value="남자"> 남자
		</label>
		<label>
			<input type="radio" name="memberGender" value="여자"> 여자
		</label>
		<label>
			<input type="radio" name="memberGender" value="선택안함" checked> 선택 안함
		</label>
		<div>
			<button>회원 가입</button>
		</div>
	</form>
</body>
</html>







