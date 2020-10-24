package Strs;

public class KMP
{
    private int[][] dfa;
    private String pat;

    public KMP(String pat)
    {
        int R = 256;
        int M = pat.length();
        this.pat = pat;
        dfa = new int[R][M];

        // dfa
        for (int X = 0, j = 0; j < M; j ++)
        {
            for (char c = 0; c < R; c ++)
                dfa[c][j] = dfa[c][X];
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][j];
        }
    }

    public int search(String s)
    {
        int i, j;
        int N = s.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i ++)
            j = dfa[s.charAt(i)][j];

        if (j == M)
            return i - j;

        return N;
    }

    public static void main(String[] args)
    {
        KMP kmp = new KMP("pat");
        System.out.println(kmp.search("partnerparjtpater"));
    }
}