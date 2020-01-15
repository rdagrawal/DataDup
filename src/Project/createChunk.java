package Project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.xml.validation.Validator;

import org.h2.value.Value;


public class createChunk 
{
	public static final int hconst = 69069; // good hash multiplier for MOD 2^32
	public int mult; // this will hold the p^n value
	int[] buffer; // circular buffer - reading from file stream
	int buffptr;
	String string_w = "";
	InputStream is;
	public static Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
	
	public void createChunks(String filelocation, ArrayList<String> new_narr) throws IOException 
	{
		mult = 1;
		buffptr = 0;
		int mask = 1 << 13;
		mask--; // 13 bit of '1's
		File f = new File(filelocation);
		FileInputStream fs;
		int cnt=0;
		try 
		{
			fs = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fs);	// BufferedInputStream is faster to read byte-by-byte from
			this.is = bis;
			long length = bis.available();
			System.out.println("**Size of file:**"+length);
			long curr = length;
			System.out.println("****CURRENT SIZE OF CURR : " + curr);
							//get the initial 1k hash window //
			Integer hash = inithash(1024-1,0);
	
			curr -= bis.available();
			
			while (curr < length) 
			{
				if ((hash & mask) == 0 || curr==length-1)
				{
					// window found - hash it, 
					// compare it to the other file chunk list
					byte[] wordArray = string_w.getBytes(); 
					String hashIn256=sha256hash.getHash256(wordArray);
					new_narr.add(hashIn256);
					if(!map.containsKey(hash))
					{
						ArrayList<String> arrr = new ArrayList<String>(Arrays.asList(hashIn256));
						map.put(hash, arrr);
						System.out.println();
						insertDb.insertInTable("HASHMAP", Integer.toString(hash), arrr);
//						map.put(hash, hashIn256);
//						System.out.println(counter+"=> no hash\tno 256\t" +"  =>  "+hash + "\tsha256\t"+hashIn256);
						file_opr.createFile(hash,string_w,hashIn256);
					}
					else if(!map.get(hash).contains(hashIn256))
					{
						
						map.get(hash).add(hashIn256);
						ArrayList<String> arrr = map.get(hash);
						insertDb.updateTable("HASHMAP", Integer.toString(hash), arrr);
//						System.out.println(counter+"=> ya hash\tno 256\t" +"  =>  "+hash + "\tsha256\t"+hashIn256);
						file_opr.createFile(hash,string_w,hashIn256);
					}
					else
					{
					}
					string_w = "";
				}
				// next window's hash  //
				hash = nexthash(hash);					
				curr++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		file_opr.joinFile(new_narr,cnt);
		cnt++;
	}

	public int nexthash(int prevhash) throws IOException
	{
		int c = is.read(); // next byte from stream
		string_w += (char) c;
		prevhash -= mult * buffer[buffptr]; // remove the last value
		prevhash *= hconst; // multiply the whole chain with prime
		prevhash += c; // add the new value
		buffer[buffptr] = c; // circular buffer, 1st pos == lastpos
		buffptr++;
		buffptr = buffptr % buffer.length;
		return prevhash;
	}
	public int inithash(int from, int to) throws IOException 
	{
		buffer = new int[from - to + 1]; // create circular buffer
		int hash = 0;
		string_w = "";
		// calculate the hash sum of p^n * a[x]
		for (int i = 0; i <= from - to; i++)
		{
			int c = is.read();
			string_w += (char) c;
			buffer[buffptr] = c; 
			buffptr++;
			buffptr = buffptr % buffer.length;
			hash *= hconst; // multiply the current hash with constant
			hash += c; // add byte to hash
			if(i>0) // calculate the large p^n value for later usage
			{
				mult *= hconst;
			}
		}
		return hash ;
	}
	public static void dispMap() {
		map.keySet().forEach(key -> System.out.println(key + "\t------>\t" + map.get(key)));
	}	
}