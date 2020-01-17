/*
 * 
 * 
 * Incomplete
 * JOin file whenever user wants to
 * access user table and copy the array_of_file
 * check their chunks and join them
 * 
 */



package Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class downloadFile extends mainFile{
	public static ArrayList<String> array_list = new ArrayList<String>();

	static String fileName;
	@SuppressWarnings({ "resource" })
	public static void download() throws IOException {
		Scanner sc = new Scanner(System.in);
		//Display All the Files
		retriveDb.retrieFileNames();
		System.out.println("Enter Name of FIle");
		fileName = sc.next();
		retriveDb.retrive_fileArray();
		file_opr.joinFile();
		System.out.println("Check File in Joined folder");
	}

}
