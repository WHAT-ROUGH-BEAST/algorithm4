package Graph;

import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.io.*;

public class In
{	
	private Scanner scanner;
	
	public In(String path)
	{
		try
		{
			scanner = new Scanner(new File(path));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Integer readInt()
	{
		if (scanner.hasNext())
			return scanner.nextInt();
		else
			return null;
	}

	public Double readDouble()
	{
		if (scanner.hasNext())
			return scanner.nextDouble();
		else
			return null;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new In("C:\\Users\\18069\\Desktop\\data.txt").readInt());
	}
}
