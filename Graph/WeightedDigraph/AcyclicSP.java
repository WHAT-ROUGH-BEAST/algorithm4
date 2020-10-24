package Graph.WeightedDigraph;

import Graph.In;
import Graph.Topological;
import Graph.WeightedGraph.Edge;

import java.util.Arrays;
import java.util.LinkedList;

public class AcyclicSP
{
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);

        Topological topological = new Topological(new DiGraphAdapter(G));
        Iterable<Integer> order = topological.order();

        distTo[s] = 0.0;
        for (int v : order)
            relaxE(G, v);
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

    public Iterable<DirectedEdge> pathTo(int v)
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
        AcyclicSP acyclicSP = new AcyclicSP(new EdgeWeightedDigraph(
                new In("C:\\Users\\18069\\Desktop\\data.txt")), 5);

        System.out.println(acyclicSP.pathTo(0));
    }
}
