package Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Run 
{
	static ArrayList<String> narr = new ArrayList<String>();
	public static Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		displayChunk d = new displayChunk();
		String fileLocation1 = "file/file1.txt";
		String fileLocation2 = "file/file2.txt";
//		String fileLocation1 = "file/img5.jpg";
//		String fileLocation2 = "file/img6.jpg";	
		
		ArrayList<String> narr1 = new ArrayList<String>();
		d.displayChunks(fileLocation1, narr1, "txt");
		System.out.println("FILE 1 Completed\nArray of File:");
		System.out.println(narr1+"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
		
		ArrayList<String> narr2 = new ArrayList<String>();
		d.displayChunks(fileLocation2, narr2 ,"txt");
		System.out.println("FILE 2 Completed\nArray of File:");
		System.out.println(narr2+"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
		displayChunk.dispMap();
		
		
	}
}