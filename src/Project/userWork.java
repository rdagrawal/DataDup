package Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class userWork extends mainFile
{
	static ArrayList<String> narr = new ArrayList<String>();
	public static Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	
	@SuppressWarnings("resource")
	public static void run() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome "+ user + "\nPlease Select a option\n\t1. Upload\n\t2. Download\n\t3. Exit");
		int ch=sc.nextInt();
		switch(ch){
		case 1:
			uploadFile.upload();
		case 2:
			downloadFile.download();
		case 3:
			System.out.println("Thank You:");
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}	
	}	
}
