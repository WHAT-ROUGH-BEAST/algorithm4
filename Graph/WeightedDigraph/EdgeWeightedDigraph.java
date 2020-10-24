package Graph.WeightedDigraph;

import Graph.In;

import java.util.Collection;
import java.util.HashSet;

public class EdgeWeightedDigraph
{
    private HashSet<DirectedEdge>[] adj;
    private final int V;
    private int E;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V)
    {
        this.V = V;
        adj = (HashSet<DirectedEdge>[]) new HashSet[V];
        for (int i = 0; i < V; i ++)
            adj[i] = new HashSet<>();
    }

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(In data)
    {
        this.V = data.readInt();
        int tempE = data.readInt();
        adj = (HashSet<DirectedEdge>[]) new HashSet[V];
        for (int i = 0; i < V; i ++)
            adj[i] = new HashSet<>();

        Integer from = data.readInt();
        while (from != null)
        {
            addEdge(new DirectedEdge(from, data.readInt(), data.readDouble()));
            from = data.readInt();
        }

        this.E = tempE;
    }

    public void addEdge(DirectedEdge e)
    {
        int v = e.from();
        adj[v].add(e);
        E ++;
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public Collection<DirectedEdge> adj(int v)
    {
        return adj[v];
    }

    public Collection<DirectedEdge> edges()
    {
        HashSet<DirectedEdge> edges = new HashSet<>();
        for (int i = 0; i < V; i ++)
            edges.addAll(adj(i));

        return edges;
    }
}
