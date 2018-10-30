package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class jdbc1 {
	@Test
	public void query() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test","root","888888");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from category");
			while(rs.next()) {
				String cid=rs.getString("cid");
				String cname=rs.getString(2);
				System.out.println(cid+":"+cname);
			}
			rs.close();
			st.close();
			conn.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
