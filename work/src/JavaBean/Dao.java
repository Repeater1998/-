package JavaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import bean.account;
public class Dao {
	public ArrayList<account> account() throws Exception{
		ArrayList<account> accounts=new ArrayList<account>();
		Connection conn = null;
	    ResultSet rs = null;
	    Statement stat = null;
	    String url = "jdbc:sqlserver://localhost:1433; DatabaseName=�û���Ϣ";
		String user = "sa";
		String pass = "1998.06.14";
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(url,user,pass);
		stat = conn.createStatement();
		String sql="SELECT �˺�,���� FROM ��¼��Ϣ;";
		rs=stat.executeQuery(sql);
		while(rs.next()) {
			account account=new account();
			account.setAccout(rs.getString("�˺�"));
			account.setPassword(rs.getString("����"));
			accounts.add(account);
		}
		rs.close();
		stat.close();
		if(conn!=null) {
			conn.close();
			conn=null;
		}
		return accounts;
	}
}
