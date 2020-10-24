package Graph.WeightedDigraph;

import Graph.In;
import Graph.WeightedGraph.IndexedPriorityQueue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class DijkstraSP
{
    private IndexedPriorityQueue<Double> pq;
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public DijkstraSP(EdgeWeightedDigraph G, int s)
    {
        pq = new IndexedPriorityQueue<>(G.V(), Double::compareTo);
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);

        distTo[s] = 0.0;
        pq.insert(s, 0.0);

        while (!pq.isEmpty())
            relaxE(G, pq.delMin());
    }

    private void relaxE(EdgeWeightedDigraph G, int v)
    {
        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();

            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                if (pq.contains(w))
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v)
    {
        return distTo[v];
    }

    public boolean hasPathTo(int v)
    {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Collection<DirectedEdge> pathTo(int v)
    {
        if (!hasPathTo(v))
            return null;

        LinkedList<DirectedEdge> path = new LinkedList<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }

    public static void main(String[] args)
    {
        DijkstraSP dijkstraSP = new DijkstraSP(new EdgeWeightedDigraph(
                new In("C:\\Users\\18069\\Desktop\\data.txt")), 0);

        System.out.println(dijkstraSP.pathTo(0));
    }
}
