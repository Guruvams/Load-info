import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PressTwo {
	public static void particularEmpData() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID : ");
		int id=sc.nextInt();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/j2ee_db";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="select * from customer_info where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("ID           : "+rs.getInt(1));
				System.out.println("NAME         : "+rs.getString(2));
				System.out.println("MobileNumber : "+rs.getString(4));
				System.out.println("EMAIL        : "+rs.getString(5));
			}
			else {
				System.err.println("Customer not found ");
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
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
