package Graph.WeightedGraph;

import Graph.In;

import java.util.Arrays;
import java.util.Collections;

public class PrimMST
{
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexedPriorityQueue<Double> pq; // 唯一的用途就是找到 distTo.min

    public PrimMST(EdgeWeightedGraph G)
    {
        int V = G.V();
        edgeTo = new Edge[V];
        distTo = new double[V];
        marked = new boolean[V];

        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        pq = new IndexedPriorityQueue<>(V, Double::compareTo);

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty())
            visit(G, pq.delMin());
    }

    private void visit(EdgeWeightedGraph G, int v)
    {
        marked[v] = true;

        for (Edge e : G.adj(v))
        {
            int w = e.other(v);

            if (marked[w]) continue;
            if (e.weight() < distTo[w])
            {
                distTo[w] = e.weight();
                edgeTo[w] = e;

                if (pq.contains(w))
                    pq.change(w, distTo[w]); // 即时删除其他边
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> Edges()
    {
        return Collections.unmodifiableList(Arrays.asList(edgeTo));
    }

    public double weight()
    {
        double weight = 0.0;
        for (double w : distTo)
            weight += w;

        return weight;
    }

    public static void main(String[] args)
    {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:\\Users\\18069\\Desktop\\data.txt"));
        PrimMST prim = new PrimMST(G);

        System.out.println(prim.Edges());
        System.out.println(prim.weight());
    }
}
