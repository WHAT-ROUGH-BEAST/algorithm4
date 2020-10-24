package Strs;

import java.util.Arrays;

public class LSD
{
    public static void sort(String[] a, int W)
    {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int c = N - 1; c >= 0; c --)
        {
            int[] count = new int[R + 1];

            for (String s : a)
                count[s.charAt(c) + 1] ++;

            for (int i = 0; i < R; i ++)
                count[i + 1] += count[i];

            for (String s : a)
                aux[count[s.charAt(c)]++] = s;

            System.arraycopy(aux, 0, a, 0, N);
        }
    }

    public static void main(String[] args)
    {
        String[] strs = {"abcde", "acdse", "adsaw"};
        LSD.sort(strs, 5);
        System.out.println(Arrays.toString(strs));
    }
}
