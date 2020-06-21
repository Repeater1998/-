<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="login.css" charset="UTF-8">
<title>Log In</title>
<script language="javascript">
    function validateLogin() {
        var sUserName = document.LoginForm.account.value;
        var sPassword = document.LoginForm.password.value;
        if ((sUserName == "") || (sUserName == "null")) {
            alert("请输入用户名!");
            return false;
        }
        if ((sPassword == "") || (sPassword == "null")) {
            alert("请输入密码!");
            return false;
        }
    }
    function set1(){
    	document.getElementById("body").style="background-image:url(../images/background.jpg)";
    }
    function set2(){
    	document.getElementById("body").style="background-image:url(../images/jure-tufekcic-1580055-unsplash.jpg)";
    }
    function refresh(){
    	LoginForm.img.src="vaildate.jsp?rnd="+Math.random();
    }
</script>
</head>
<body id="body" style="background-image:url(../images/adult-competition-concentration-929831.jpg)">
	<%
	String userName = null;
	String key = null;
	Cookie[] cookie = request.getCookies();
	if(cookie !=null){              
	    for(Cookie c:cookie){  // 遍历Cookie
	       if("account".equals(c.getName()))
	    	   userName = c.getValue();      
	       if("password".equals(c.getName())) 
	           key= c.getValue();       
	    }
	}
	%>
	<% %>
	<div id="content">
		<div class="login-header">
			<img src="../images/logo.png">
		</div>
		<form action="/work/LoginServlet" method="post" name="LoginForm">
		<div class="login-input-box">
			<span class="icon icon-user"></span>
			<input name="account" type="text" value="<%=userName%>"><br>
		</div>
		<div class="login-input-box">
			<span class="icon icon-password"></span>
			<input name="password" type="text" value="<%=key%>"><br>
		</div>
		<div class="remember-box">
        	<label>
            	是否保存登录状态：
				是<input value="yes" type="checkbox" name="cookie">
				否<input value="no" type="checkbox" name="cookie"><br>
				验证码：<input type="text" name="code" size="10">
				<img name="img" src="vaildate.jsp" onclick="refresh()">
        	</label>
    	</div>
    	<div class="login-button-box">
    		<input value="登录" type="submit" name="choose" onClick="return validateLogin()" style="width:420px"><br>
    		<input value="注册" type="button" onclick="window.open('register.jsp','_self')" style="width:420px"><br>
    	</div>
		</form>
	</div>
	<form>
		<input type="button" onClick="set1()" value="image1">
		<input type="button" onClick="set2()" value="image2">
	</form>
	<%response.setHeader("Refresh", "60"); %>
	<%@include file="about_us.jsp"%>
</body>
</html>