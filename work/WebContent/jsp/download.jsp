<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String filename=(String)session.getAttribute("name");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		response.setContentType("imge/jpeg");
		RequestDispatcher rd=request.getRequestDispatcher("/FILES/"+filename);
		rd.forward(request, response);
	%>
</body>
</html>