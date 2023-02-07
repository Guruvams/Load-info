import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PressOne {
	public static void entireData() {
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/j2ee_db";
			con=DriverManager.getConnection(dburl,"root","root");
			String call="call  entireTable()";
			cstmt=con.prepareCall(call);
			boolean bool=cstmt.execute();
			if(bool==true) {
				rs=cstmt.getResultSet();
				while(rs.next()) {
					System.out.println("ID           : "+rs.getInt(1));
					System.out.println("NAME         : "+rs.getString(2));
					System.out.println("SALARY       : "+rs.getDouble(3));
					System.out.println("MobileNumber : "+rs.getString(4));
					System.out.println("EMAIL        : "+rs.getString(5));
				}
			}
		} 
		catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(cstmt!=null) {
					cstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
