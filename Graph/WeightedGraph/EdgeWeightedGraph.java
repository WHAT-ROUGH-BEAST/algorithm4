package Graph.WeightedGraph;

import Graph.In;

import java.util.Collection;
import java.util.HashSet;

public class EdgeWeightedGraph
{
    private HashSet<Edge>[] adj;
    private int V, E;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(In data)
    {
        this.V = data.readInt();
        int tempE = data.readInt();

        adj = (HashSet<Edge>[]) new HashSet[V];
        for (int i = 0; i < adj.length; i ++)
            adj[i] = new HashSet<>();

        Integer p = data.readInt();
        while (p != null)
        {
            addEdge(p, data.readInt(), data.readDouble());
            p = data.readInt();
        }

        this.E = tempE;
    }

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V)
    {
        this.V = V;
        adj = (HashSet<Edge>[]) new HashSet[V];
        for (int i = 0; i < adj.length; i ++)
            adj[i] = new HashSet<>();
    }

    public void addEdge(int v, int w, double weight)
    {
        Edge e = new Edge(v, w, weight); // 同一个边，没有方向
        adj[v].add(e);
        adj[w].add(e);
        E ++;
    }

    public int V()
    {   return V;   }

    public int E()
    {   return E;   }

    public Collection<Edge> adj(int v)
    {
        return adj[v];
    }

    public Collection<Edge> edges()
    {
        HashSet<Edge> edges = new HashSet<>(E);
        for (int i = 0; i < V; i ++)
            edges.addAll(adj(i));

        return edges;
    }
}
