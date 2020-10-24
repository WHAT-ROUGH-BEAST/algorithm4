package Graph.WeightedDigraph;

import Graph.Digraph;

public class DiGraphAdapter extends Digraph
{
    public DiGraphAdapter(EdgeWeightedDigraph EG)
    {
        super(EG.V());
        for (int i = 0; i < EG.V(); i ++)
            for (DirectedEdge e : EG.adj(i))
                super.addEdge(e.from(), e.to());
    }
}
