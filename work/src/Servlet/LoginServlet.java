package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.Crypto;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String an=request.getParameter("code");
		HttpSession session=request.getSession();
		String ans=(String)session.getAttribute("ans");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if(!an.equals(ans)) {
			out.println("验证码错误！");
			return;
		}
		Crypto cry=new Crypto();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PreparedStatement ps = null;
	    Connection conn = null;
	    ResultSet rs = null;
	    Statement stat = null;
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=用户信息";
		String user = "sa";
		String pass = "1998.06.14";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,user,pass);
			stat = conn.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String choose=request.getParameter("cookie");
		if(choose.equals("yes")){
			Cookie Account=new Cookie("account",account); 
			Cookie Password=new Cookie("password",password);
			Account.setMaxAge(60*60*24);
			Password.setMaxAge(60*60*24);
			response.addCookie(Account);
			response.addCookie(Password);
		}
			String sql="SELECT 密码 FROM 登录信息 WHERE 账号=?;";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, account);
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String PASSWORD = null;
			try {
				while(rs.next()) {
					PASSWORD=rs.getString("密码");
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String jiemi=cry.decrypt(cry.encrypt(PASSWORD, "123456789"), "123456789");
			try {
				rs.close();
				stat.close();
				if(conn!=null) {
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if(jiemi.equals(password)){
				session.setAttribute("account",account);
				response.sendRedirect("/work/jsp/index.jsp");
			}else {
				response.sendRedirect("/work/jsp/login.jsp");
			}
	 }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
