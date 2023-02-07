import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MobilenumberUpdate {
	public void salaryMobileNumber() {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pstmt=null;
		System.out.println("Enter MobileNumber");
		String mb=sc.next();
		System.out.println("Enter id : ");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/j2ee_db";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="update customer_info set mobilenumber=? where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, mb);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("MobileNumber Updated");
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
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
