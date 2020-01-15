package Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class uploadFile {


	@SuppressWarnings("static-access")
	public static void upload() throws IOException {
		createChunk d = new createChunk();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of files want to upload");
		int n = sc.nextInt();
		for(int i =0; i<n; i++) {
			System.out.println("Enter File Name:\t");
			String st = sc.nextLine();
			ArrayList<String> arr1 = new ArrayList<String>();
			String fileLocation = "file/"+st;
			d.createChunks(fileLocation, arr1);
			System.out.println("----------------------------------------------------------------------");
			
			d.dispMap();
			
			
			
			
		}
	}
}
