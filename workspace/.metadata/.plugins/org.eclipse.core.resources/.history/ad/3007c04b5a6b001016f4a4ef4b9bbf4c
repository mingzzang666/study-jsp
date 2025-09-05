<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex01</title>
<style>
   #name-message {
      color:black;
   }
   #name-message.active {
      color: red;
   }
</style>
</head>
<body>
   <form action="ex01" method="post" name="nameForm">
      <input type="text" name="memberName" placeholder="이름을 입력해주세요.">
      <p id="name-message"></p>
      <input type="button" value="전송">
   </form>
</body>
<script>
   const input = nameForm.memberName;
   const button = document.querySelector("input[type=button]");
   const p = document.getElementById("name-message");
   
   button.addEventListener("click", (e) => {
      p.classList.toggle("active", !input.value);
      p.innerText = input.value ? "" : "아이디를 입력해주세요.";
      input.value && nameForm.submit(); 
   })
   
</script>
</html>




