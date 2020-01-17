package Project;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mainFile 
{
	public static Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
	public static String user;
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		System.out.println("Welcome to deduplication :)\nExtracting Data from Database");
		retriveDb.retrive_hashmap();
		
		map.keySet().forEach(key -> System.out.println(key + "\t------>\t" + map.get(key)));
		
		
		
		Scanner sc=new Scanner(System.in);
		//1. Login check
		login log=new login();
		System.out.println("Enter the user name: ");
		user="Rahul7691";
		System.out.println("Enter the password: ");
		String pass="Rahul";
		boolean ans=log.checklog("Rahul7691","Rahul");
		System.out.println("ans is:   "+ ans);

		if(ans==true)
		{
			System.out.println("Login Success");
			userWork.run();
		}
		else
		{
			System.out.println("Invalid Credentials: Do you want to register(0/1)");
			int ch=sc.nextInt();
			switch(ch){
			case 0:
				System.out.println("Thank You");
			case 1:
				System.out.println("Enter the name: ");
				String name=sc.next();
				System.out.println("Enter the email: ");
				String email=sc.next();
				System.out.println("Enter the last 4 digit of contact: ");
				int contact=sc.nextInt();
				insertDb.createLogin(user,pass);
				insertDb.createTable(user);
				insertDb.createdETAILS(user, name, email, contact);
				userWork.run();
			default:
				break;
				}
		}
	}
}