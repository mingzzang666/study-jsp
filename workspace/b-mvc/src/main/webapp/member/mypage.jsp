<%@page import="com.app.domain.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	#check {
		color: red;
	}
</style>
</head>
<body>
	<% 
		MemberVO member = (MemberVO)request.getAttribute("member");
		String email = request.getParameter("email");
	%>
	
	<a href="/logout.member">로그아웃</a>
	<a href="/write.post">게시글 작성</a>
	<h1><%=member.getMemberName()%>님 환영합니다.</h1>
	<form action="/update-ok.member" method="post">
		<div>
			<input type="text" name="memberEmail" value="<%=member.getMemberEmail()%>">
		</div>
		<%if(email != null) {%>
		<div>
			<p id="check">
				이미 존재하는 이메일입니다.
			</p>
		<%} %>
		</div>
		<div>
			<input type="text" name="memberName" value="<%=member.getMemberName()%>">
		</div>
		<div>
			<input type="text" name="memberAge" value="<%=member.getMemberAge()%>">
		</div>
		<div>
			<input type="radio" name="memberGender" value="남자" <%=member.getMemberGender().equals("남자") ? "checked" : ""%>> 남자
			<input type="radio" name="memberGender" value="여자" <%=member.getMemberGender().equals("여자") ? "checked" : ""%>> 여자
			<input type="radio" name="memberGender" value="선택 안함" <%=member.getMemberGender().equals("선택 안함") ? "checked" : ""%>> 선택 안함
		</div>
		<button>수정 완료</button>
	</form>
	<a href="/delete-ok.member">회원 탈퇴</a>
</body>
</html>









