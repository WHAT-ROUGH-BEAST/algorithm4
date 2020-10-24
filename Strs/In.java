package Strs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class In
{
    public static String read()
    {
        StringBuilder builder = new StringBuilder();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("C:\\Users\\18069\\Desktop\\gone.txt")));

            for (String s = ""; s != null; s = reader.readLine())
                builder.append(s);

            reader.close();

            return builder.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
