<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
</head>
	<body>
	<h2>登录界面</h2>
		<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
			用户名:<input type="text" name="j_username" /><br />
			密码:<input type="password" name="j_password" /><br />
			<input type="submit" value="登录">
		</form>
	</body>
</html>
