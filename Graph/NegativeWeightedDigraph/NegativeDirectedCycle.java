package Graph.NegativeWeightedDigraph;

import Graph.WeightedDigraph.DirectedEdge;
import Graph.WeightedDigraph.EdgeWeightedDigraph;

import java.util.LinkedList;

public class NegativeDirectedCycle
{
    private boolean[] onStack;
    private boolean[] marked;
    private LinkedList<DirectedEdge> cycle;
    private DirectedEdge[] edgeTo;

    public NegativeDirectedCycle(EdgeWeightedDigraph G)
    {
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v = 0; v < G.V(); v ++)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(EdgeWeightedDigraph G, int v)
    {
        if (v >= G.V())
            throw new RuntimeException();

        marked[v] = true;
        if (cycle != null)	return;

        onStack[v] = true;

        for (DirectedEdge e : G.adj(v))
        {
            int w = e.to();
            if (!marked[w])
            {
                edgeTo[w] = e;
                dfs(G, w);
            }
            else if (onStack[w])
            {
                cycle = new LinkedList<>();
                cycle.push(e);
                for (DirectedEdge c = edgeTo[v]; c != e; e = edgeTo[e.from()])
                    cycle.push(c);

                // cycle ±ØÈ»žéØ“

                return;
            }
        }

        onStack[v] = false;
    }

    public boolean hasNegativeCycle()
    {
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle()
    {
        return cycle;
    }
}
