<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="JavaBean.Dao" %>
<%@page import="bean.account" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="index.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游戏玩家</title>
</head>
<body>
<div class="header">
  <h1>游戏玩家</h1>
  <p>-50% -75%</p>
</div>

<div class="topnav">
  <a href="user.jsp">用户信息</a>
  <a href="#"></a>
  <a href="#"></a>
  <a href="#" style="float:right"></a>
</div>

<div class="row">
  <div class="leftcolumn">
    <div class="card">
      <h2></h2>
      <h5>文件上传</h5>
      <div class="fakeimg" style="height:200px;">图片</div>
      <p>一些文本...</p>
      <p>内容</p>
    </div>
    <div class="card">
      <h2>文章标题</h2>
      <h5>日期</h5>
      <div class="fakeimg" style="height:200px;">图片</div>
      <p>一些文本...</p>
      <p>内容</p>
    </div>
  </div>
  <div class="rightcolumn">
    <div class="card">
      <h2>关于我</h2>
      <div class="fakeimg" style="height:100px;">图片</div>
      <%
  	  String a=(String)session.getAttribute("account");
  	  %>
  	  <%=a %>
      <p>账户名</p>
    </div>
    <div class="card">
      <h3>热门文章</h3>
      <div class="fakeimg"><p>图片</p></div>
      <div class="fakeimg"><p>图片</p></div>
      <div class="fakeimg"><p>图片</p></div>
    </div>
    <div class="card">
      <h3>关注我</h3>
      <p>一些文本...</p>
    </div>
  </div>
</div>

<div class="footer">
  <h2>当前在线人数</h2>
  <% 
  Integer count=(Integer)application.getAttribute("count");
  if(count==null){
	  count=new Integer(0);
  }
  count++;
  application.setAttribute("count", count);
  %>
  <%=count %>
  <h2>登录账号</h2>
  <%
  Dao dao=new Dao();
  ArrayList<account> accounts=dao.account();
  for(int i=0;i< accounts.size();i++){
	  account account=(account)accounts.get(i);
  %>
  <%=account.getAccount() %>
  <%
  }
  %>
  <%@include file="about_us.jsp"%>
</div>
	
</body>
</html>