/*
 * 
 * 
 * Don't Touch It
 * 
 * 
 * 
 * 
 */



package Project;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class file_opr extends downloadFile
{
	public static void createFile(int hash_val,String word, String hash256val) throws IOException
	{
		String filename = "chunks/"+hash256val;
		FileWriter fw = new FileWriter(filename);
		fw.write(word);
		fw.close();
	}
	public static void joinFile() throws IOException  
	{
		
		String filenamej = "joined/"+ fileName;
		FileWriter fw_join = new FileWriter(filenamej);
		FileReader fr;
		for(int i = 0 ; i < array_list.size() ; i++)
		{
			array_list.get(i);
			String fileNameJoin = "chunks/"+array_list.get(i);
			fr = new FileReader(fileNameJoin);
            int c = fr.read();
            while(c!=-1) {
                fw_join.write(c);
                c = fr.read();         
            }
            fr.close(); 
		}
		fw_join.close();
		System.out.println("**************************File Joined*****************************");
	}
}
