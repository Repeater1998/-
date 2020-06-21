<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/work/RegisterServlet" method="post">
		<input name="R_account" type="text"><br>
		<input name="R_password" type="text"><br>
		<input name="choose" type="submit" value="注册">
	</form>
	<form action="/work/UploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="myfile">
		<input type="submit" value="上传">
	</form>
	${msg}
</body> 
</html>