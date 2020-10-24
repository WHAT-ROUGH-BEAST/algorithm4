package Graph.WeightedDigraph;

import Graph.In;

import java.util.ArrayList;

public class DijTree
{
    private boolean[] marked;
    private ArrayList<DirectedEdge> edges;

    public DijTree(In in)
    {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        marked = new boolean[G.V()];
        edges = new ArrayList<>();

        int v0 = 0;
        marked[v0] = true;
        DijkstraSP sp = new DijkstraSP(G, v0);
        for (int w = 0; w < G.V(); w ++)
            if (!marked[w])
            {
                marked[w] = true;
                edges.addAll(sp.pathTo(w));
            }

        System.out.println(edges);
    }

    public static void main(String[] args)
    {
        DijTree tree = new DijTree(new In("C:\\Users\\18069\\Desktop\\data.txt"));
    }
}
