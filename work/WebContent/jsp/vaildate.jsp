<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.awt.*,java.util.*,javax.imageio.ImageIO,java.awt.image.BufferedImage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <%
	 response.setHeader("Cache-Control", "no-cache");
	 int width=60,height=20;
	 BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	 Graphics g=image.getGraphics();
	 g.setColor(new Color(200,200,200));
	 g.fillRect(0, 0, width, height);
	 Random rnd=new Random();
	 int randNum1=rnd.nextInt(9);
	 int randNum2=rnd.nextInt(9);
	 int ans=randNum1+randNum2;
	 String num=randNum1+"+"+randNum2;
	 String ranNum=String.valueOf(ans);
	 session.setAttribute("ans", ranNum);
	 g.setColor(Color.black);
	 g.setFont(new Font("",Font.PLAIN,20));
	 g.drawString(num, 10, 17);
	 for(int i=0;i<100;i++){
		 int x=rnd.nextInt(width);
		 int y=rnd.nextInt(height);
		 g.drawOval(x, y, 1, 1);
	 }
	 ImageIO.write(image, "JPEG", response.getOutputStream());
	 out.clear();
	 out=pageContext.pushBody();
	 %>
</body>
</html>