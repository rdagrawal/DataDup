package Project;

import java.util.Scanner;

public class downloadFile extends mainFile{

	static String fileName;
	@SuppressWarnings({ "resource" })
	public static void download() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of FIle");
		//Display All the Files
		retriveDb.retrieFileNames();
		fileName = sc.next();
		retriveDb.retrive_fileArray();
		
		
		
		
		
		
		

		
		
		
	}

}
