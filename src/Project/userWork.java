/*
 * 
 * 
 * Don't Touch it
 * 
 * 
 * 
 */




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
		System.out.println("Welcome "+ user + "\nPlease Select a option\n\t1. Upload File\n\t2. Download File\n\t3. Delete File\n\t4. Delete User\n\t5. Exit");
		int ch=sc.nextInt();
		switch(ch){
		case 1:
			uploadFile.upload();
			break;
		case 2:
			downloadFile.download();
			break;
		case 3:
			deleteData.deleteFile();
			break;
		case 4:
			deleteData.deleteUser();
			break;
		case 5:
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}	
	}	
}
