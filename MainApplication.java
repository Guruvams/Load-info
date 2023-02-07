import java.util.Scanner;

public class MainApplication {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Press [1] for See Entire table.");
		System.out.println("Press [2] for see particular customer details.");
		System.out.println("Press [3] for to insert customer records");
		System.out.println("Press [4] for to update a customer record");
		System.out.println("Press [5] for to delete a customer record");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:PressOne.entireData();
			break;
		case 2:PressTwo.particularEmpData();
			break;
		case 3:PressThree.insertcustomer();
			break;
		case 4:PressFour pf=new PressFour();
			   pf.selectOne();
			break;
		case 5:PressFive.deleteRecord();
			break;
		default:System.err.println("INVALID");
		}
	}
}
