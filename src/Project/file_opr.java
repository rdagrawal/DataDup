package Project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class file_opr
{
	public static void createFile(int hash_val,String word, String hash256val, String file_format) throws IOException
	{
		String filename = "chunks/"+hash256val+"."+file_format;
		FileWriter fw = new FileWriter(filename);
		fw.write(word);
		fw.close();
	}
	public static void joinFile(ArrayList<String> new_narr, int cnt,String file_format) throws IOException  
	{
		
		String filenamej = "joined/joinFile"+ cnt +"."+file_format;
		FileWriter fw_join = new FileWriter(filenamej);
		FileReader fr;
		for(int i = 0 ; i < new_narr.size() ; i++)
		{
			String fileNameJoin = "chunks/"+new_narr.get(i)+"."+file_format;
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
