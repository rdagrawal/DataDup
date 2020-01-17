package Project;

import java.util.Scanner;

public class deleteData extends userWork{
	static String fileName;
	static Scanner sc = new Scanner(System.in);
	public static void deleteFile() {
		retriveDb.retrieFileNames();
		System.out.println("Enter File Name You Want To Delete:");
		fileName = sc.next();
		insertDb.deleteFile(fileName);
	}
	public static void deleteUser() {
		insertDb.deleteUser();
	}

}
