package Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class uploadFile extends userWork {
	public static String fileLocation;
	public static String fileName;
	public static ArrayList<String> array_of_file_sha = new ArrayList<String>();;


	public static void upload() throws IOException {
		createChunk d = new createChunk();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of files want to upload");
		int n = sc.nextInt();
		for(int i =0; i<n; i++) {
			System.out.println("Enter File Name:\t");
			fileName = sc.next();
			
			fileLocation = "file/"+fileName;
			d.createChunks();
			System.out.println("--------------------------FILE "+i+"--------------------------------------------");		
		}
		System.out.println("Thank You: Files Uploaded");
	}
}
