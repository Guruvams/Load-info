import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PressThree {
	public static void insertcustomer() {
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/j2ee_db";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="insert into customer_info values(?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			System.out.println("Enter Name : ");
			String name=sc.next();
			System.out.println("Enter salary : ");
			double salary=sc.nextDouble();
			System.out.println("Enter mobilenumber :");
			String mobilenumber=sc.next();
			System.out.println("Email : ");
			String email=sc.next();
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, salary);
			pstmt.setString(4, mobilenumber);
			pstmt.setString(5, email);
			pstmt.executeUpdate();
			System.out.println("DATA UPDATED!!!!!!!!");
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
