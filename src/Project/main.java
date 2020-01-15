package Project;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main 
{
	
	public static Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		//1. Login check
		login log=new login();
		System.out.println("Enter the user name: ");
		String user=sc.nextLine();
		System.out.println("Enter the password: ");
		String pass=sc.nextLine();
		boolean ans=log.checklog(user,pass);
		if(ans==true)
		{
			System.out.println("Login Success");
			userWork.run(user);
		}
		else
		{
			System.out.println("Retry with correct credentials");
		}		
	}
}