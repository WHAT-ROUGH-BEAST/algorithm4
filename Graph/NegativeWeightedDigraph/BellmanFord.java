package Graph.NegativeWeightedDigraph;

import Graph.Digraph;
import Graph.DirectedCycle;
import Graph.In;
import Graph.WeightedDigraph.DirectedEdge;
import Graph.WeightedDigraph.EdgeWeightedDigraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord
{
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] inQ;
    private Queue<Integer> queue;
    private Iterable<DirectedEdge> cycle;
    private int cost = 0;

    public BellmanFord(EdgeWeightedDigraph G, int s)
    {
        inQ = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[s] = 0;

        queue = new LinkedList<>();
        queue.offer(s);
        inQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle())
        {
            int v = queue.poll();
            inQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v)
    {
        if (v > G.V())
            throw new RuntimeException();

        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                if (!inQ[w])
                {
                    queue.offer(w);
                    inQ[w] = true;
                }
            }
        }

        if (cost ++ % G.V() == 0)
            findNegativeCycle();
    }

    private void findNegativeCycle()
    {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(edgeTo.length);
        for (DirectedEdge e : edgeTo)
            if (e != null)
                G.addEdge(e);

        NegativeDirectedCycle cycleFinder = new NegativeDirectedCycle(G);
        cycle = cycleFinder.cycle();
    }

    public boolean hasNegativeCycle()
    {
        return cycle != null;
    }

    public static void main(String[] args)
    {
        BellmanFord bf = new BellmanFord(new EdgeWeightedDigraph(
                new In("C:\\Users\\18069\\Desktop\\data.txt")), 0);
        System.out.println(bf.cycle);
    }
}
