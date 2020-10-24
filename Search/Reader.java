package Search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Reader
{
	public static List<String> mappedFile(String path)
	{
		int length = 0x8fff;
		try
		{
			@SuppressWarnings("resource")
			MappedByteBuffer mapbuffer = new RandomAccessFile(path, "rw").
					getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
			
			String str = Charset.forName("utf-8").decode(mapbuffer).toString();
			
			List<String> list = new ArrayList<>();
			
			for (int i = 0; i < str.length(); i ++)
			{
				list.add(String.valueOf(str.charAt(i)));
			}
			
			return list;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
