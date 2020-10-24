package Strs;

import java.util.Arrays;

public class String3Sort
{
    public static void main(String[] args)
    {
        String[] list = {"she", "sells", "seashells", "by", "the", "sea", "shore",
        "the", "shells", "she", "sells", "are", "surely", "seashells"};

        sort(list);

        System.out.println(Arrays.toString(list));
    }

    public static void sort(String[] list)
    {
        sort(list, 0, list.length - 1, 0);
    }

    /**
     *
     * @param list list to be sorted
     * @param lo list lower bond
     * @param hi list upper bond
     * @param d for the index of char to be compared in this recursion
     */
    private static void sort(String[] list, int lo, int hi, int d)
    {
        if (hi <= lo)
            return;

        int lt = lo, gt = hi;
        int v = charAt(list[lo], d);

        // elems in [lt, i - 1] equals v
        int i = lo + 1;
        while (i <= gt)
        {
            int c = charAt(list[i], d);
            if (c < v)
                exchange(list, lt ++, i ++);
            else if (c > v)
                exchange(list, i, gt --);
            else
                i ++;
        }

        sort(list, lo, lt - 1, d);
        if (v >= 0)
            sort(list, lt, gt, d + 1);
        sort(list, gt + 1, hi, d);
    }

    private static void exchange(String[] list, int i, int j)
    {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static int charAt(String s, int d)
    {
        return s.length() - 1 < d ? -1 : s.charAt(d);
    }
}
