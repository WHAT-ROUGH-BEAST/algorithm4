package Graph;

import java.util.*;

public class BFS
{
    private boolean[] marked;
    private int[] edge;
    private Queue<Integer> queue;
    private final int start;
    private Graph graph;

    public BFS(Graph graph, int start)
    {
        this.graph = graph;
        this.start = start;

        marked = new boolean[graph.E()];
        edge = new int[graph.E()];
        queue = new LinkedList<>();

        bfs(start);
    }

    public void bfs(int start)
    {
        if (start > graph.E())
            throw new RuntimeException("e > E");

        marked[start] = true;
        edge[start] = start;

        queue.offer(start);
        while (!queue.isEmpty())
        {
            int v = queue.poll();
            for (int w : graph.adj(v))
            {
                if (!marked[w])
                {
                    marked[w] = true;
                    edge[w] = v;
                    queue.offer(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v)
    {
        if (!hasPathTo(v))
            return null;

        LinkedList<Integer> stack = new LinkedList<>();

        int w = v;
        while (w != start)
        {
            stack.push(w);
            w = edge[w];
        }
        stack.push(start);

        return stack;
    }

    public static void main(String[] args)
    {
        BFS bfs = new BFS(new Graph(new In("C:\\Users\\18069\\Desktop\\data.txt")), 0);
        System.out.println(bfs.pathTo(4));
    }
}
