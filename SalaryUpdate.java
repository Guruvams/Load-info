import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SalaryUpdate {
	public void salaryUpdate() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter salary");
		int salary=sc.nextInt();
		System.out.println("Enter id :");
		int id=sc.nextInt();
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/j2ee_db";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="update customer_info set salary=? where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setDouble(1, salary);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("Salary Updated");
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
