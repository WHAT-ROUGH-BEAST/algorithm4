package Strs;

public class SubStr
{
    public static int subStr(String s, String pat)
    {
        int M = s.length();
        int N = pat.length();

        for (int i = 0; i < M; i ++)
        {
            int j;
            for (j = 0; j < N; j ++)
            {
                if (s.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == N)
                return i;
        }

        return M;
    }

    public static void main(String[] args)
    {
        System.out.println(subStr("String", "rin"));
    }
}
