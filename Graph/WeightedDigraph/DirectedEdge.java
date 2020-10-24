package Graph.WeightedDigraph;

public class DirectedEdge implements Comparable<DirectedEdge>
{
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from()
    {
        return v;
    }

    public int to()
    {
        return w;
    }

    public double weight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return String.format("%d->%d %.2f", v, w, weight);
    }

    @Override
    public int compareTo(DirectedEdge o)
    {
        if (this.weight > o.weight)
            return 1;
        else if (this.weight < o.weight)
            return -1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof DirectedEdge)
        {
            DirectedEdge e = (DirectedEdge) obj;
            if (e.from() == this.from() && e.to() == this.to()
                    && e.weight == this.weight)
                return true;
        }

        return false;
    }
}
