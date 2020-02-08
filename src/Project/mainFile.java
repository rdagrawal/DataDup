/*
 * 
 * 
 * In Process
 * 
 * 
 * 
 */

package Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mainFile 
{
	public static Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
	public static Map<String, Integer> map4count = new HashMap<String,Integer>();
	
	public static String user;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		System.out.println("Welcome to deduplication :)\nExtracting Data from Database");
		retriveDb.retrive_hashmap();
		retriveDb.retrive_hashCount();
		
		map.keySet().forEach(key -> System.out.println(key + "\t------>\t" + map.get(key)));
		map4count.keySet().forEach(key -> System.out.println(key + "\t------>\t" + map4count.get(key)));
		
		Scanner sc=new Scanner(System.in);
		//1. Login check
		login log=new login();
		System.out.println("Enter the user name: ");
		user=sc.next();
		System.out.println("Enter the password: ");
		String pass=sc.next();
		boolean ans=log.checklog(user,pass);

		if(ans==true)
		{
			System.out.println("Login Success");
			userWork.run();
		}
		else
		{
			System.out.println("Invalid Credentials or User Not Exist: Do you want to register(0/1)");
			int ch=sc.nextInt();
			switch(ch){
			case 0:
				System.out.println("Thank You");
				break;
			case 1:
				System.out.println("Enter the name: ");
				String name=sc.next();
				System.out.println("Enter the email: ");
				String email=sc.next();
				System.out.println("Enter contact number : ");
				long contact=sc.nextLong();
				insertDb.InsertInLogin(user, pass, name, email, contact);
			default:
				break;
				}
		}
		map4count.keySet().forEach(key -> System.out.println(key + "\t------>\t" + map4count.get(key)));
	}
	
}