package Graph.WeightedGraph;

import Graph.In;

import java.util.*;

public class KruskalMST
{
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G)
    {
        mst = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        UF uf = new UF(G.V());

        for (Edge e : G.edges())
            pq.offer(e);

        while (!pq.isEmpty() && mst.size() < G.V() - 1)
        {
            Edge e = pq.poll();
            int v= e.either(),
                    w = e.other(v);
            if (uf.connected(v, w)) continue;

            mst.offer(e);
            uf.union(v, w);
        }
    }

    public Iterable<Edge> Edges()
    {
        return mst;
    }

    public double weight()
    {
        double weight = 0.0;
        for (Edge e : mst)
            weight += e.weight();

        return weight;
    }

    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:\\Users\\18069\\Desktop\\data.txt"));
        KruskalMST prim = new KruskalMST(G);

        System.out.println(prim.Edges());
        System.out.println(prim.weight());
    }
}
