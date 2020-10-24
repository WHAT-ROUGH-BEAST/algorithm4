package Graph.WeightedGraph;

public class UF
{
    private int[] uf;
    private int[] sz;

    public UF(int size)
    {
        uf = new int[size];
        for (int i = 0; i < size; i ++)
            uf[i] = i;

        sz = new int[size];
    }

    public boolean connected(int v, int w)
    {
        return find(v) == find(w);
    }

    // find root
    private int find(int v)
    {
        while (uf[v] != v)
            v = uf[v];

        return v;
    }

    public void union(int v, int w)
    {
        int vr = find(v);
        int wr = find(w);

        if (sz[vr] > sz[wr])
        {
            uf[wr] = vr;
            sz[vr] += sz[wr];
        }
        else
        {
            uf[vr] = wr;
            sz[wr] += sz[vr];
        }
    }
}
