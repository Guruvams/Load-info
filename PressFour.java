import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PressFour {
	Scanner sc=new Scanner(System.in);
	Connection con=null;
	PreparedStatement pstmt=null;
	SalaryUpdate su=new SalaryUpdate();
	MobilenumberUpdate mu=new MobilenumberUpdate();
	EmailUpdate eu=new EmailUpdate();
	public void selectOne() {
		System.out.println("press [1] for salary Update");
		System.out.println("press [2] for Mobilenumber Update");
		System.out.println("press [3] for email Update");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:su.salaryUpdate();
			break;
		case 2:mu.salaryMobileNumber();
			break;
		case 3:eu.salaryEmail();
			break;
		default:System.err.println("INVALID OPTION");
		}
	}
	
}
