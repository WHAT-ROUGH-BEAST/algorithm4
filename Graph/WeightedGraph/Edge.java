package Graph.WeightedGraph;

public class Edge implements Comparable<Edge>
{
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either()
    {   return v;   }

    public int other(int ver)
    {
        if (ver == v) return w;
        else if (ver == w) return v;

        throw new RuntimeException();
    }

    public double weight()
    {   return weight;  }

    @Override
    public int compareTo(Edge o)
    {
        if (this.weight > o.weight)
            return 1;
        else if (this.weight < o.weight)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString()
    {
        return v + "--" + w + "  " + weight;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Edge)
        {
            Edge e = (Edge) obj;
            if (this.weight == (e.weight))
            {
                if (this.w == e.either() && this.v == e.other(this.w))
                    return true;
                else if (this.v == e.either() && this.w == e.other(this.v))
                    return true;
            }
        }

        return false;
    }
}
