package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Crypto;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Crypto cry=new Crypto();
		PreparedStatement ps = null;
	    Connection conn = null;
	    ResultSet rs = null;
	    Statement stat = null;
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=�û���Ϣ";
		String user = "sa";
		String pass = "1998.06.14";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,user,pass);
			stat = conn.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		String R_account=request.getParameter("R_account");
		String R_password=request.getParameter("R_password");
		String jiami=cry.decrypt(R_password, "123456789");
		if(R_account!=null&&R_password!=null){
			String sql="INSERT INTO ��¼��Ϣ(�˺�,����) VALUES(?,?);";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, R_account);
				ps.setString(2, jiami);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			try {
				ps.close();
				stat.close();
				if(conn!=null) {
					conn.close();
					conn=null;
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
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
