package Project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class file_opr
{
	public static void createFile(int hash_val,String word, String hash256val) throws IOException
	{
		String filename = "chunks/"+hash256val;
		FileWriter fw = new FileWriter(filename);
		fw.write(word);
		fw.close();
	}
	public static void joinFile(ArrayList<String> new_narr, int cnt) throws IOException  
	{
		
		String filenamej = "joined/joinFile"+ cnt +".txt";
		FileWriter fw_join = new FileWriter(filenamej);
		FileReader fr;
		for(int i = 0 ; i < new_narr.size() ; i++)
		{
			String fileNameJoin = "chunks/"+new_narr.get(i);
			fr = new FileReader(fileNameJoin);
            int c = fr.read();
            while(c!=-1) {
                fw_join.write(c);
                c = fr.read();         
            }
            fr.close(); 
		}
		cnt++;
		fw_join.close();
		System.out.println("**************************File Joined*****************************");
	}
}
