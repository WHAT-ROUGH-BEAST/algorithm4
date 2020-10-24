package Graph.WeightedGraph;

import java.util.*;

public class IndexedPriorityQueue<T extends Comparable<? super T>>
{
    private ArrayList<T> table;
    private final int N;
    private PriorityQueue<T> queue;

    @SuppressWarnings("unchecked")
    public IndexedPriorityQueue(int size, Comparator<T> comparator)
    {
        this.N = size;
        table = new ArrayList<>(Arrays.asList((T[]) new Comparable[size]));
        queue = new PriorityQueue<>(size, comparator);
    }

    public void insert(int i, T elem)
    {
        if (i >= N)
            throw new RuntimeException("oversize");

        if (contains(i))
            throw new RuntimeException("index already taken");

        table.set(i, elem);
        queue.offer(elem);
    }

    public void change(int i, T elem)
    {
        if (i >= N)
            throw new RuntimeException("oversize");

        if (contains(i))
            queue.remove(table.get(i));

        table.set(i, elem);
        queue.offer(elem);
    }

    public int delMin()
    {
        T top = queue.poll();
        for (int i = 0; i < table.size(); i ++)
            if (table.get(i) != null && table.get(i).equals(top))
            {
                table.set(i, null);
                return i;
            }

        throw new RuntimeException("can't find");
    }

    public boolean contains(int i)
    {
        return table.get(i) != null;
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    @Override
    public String toString()
    {
        return queue.toString();
    }

    public static void main(String[] args)
    {
        IndexedPriorityQueue<String> strs = new IndexedPriorityQueue<>(10, String::compareTo);

        for (int i = 0; i < 10; i ++)
            strs.insert(i, String.valueOf(i));

        strs.change(5, "5+");

        for (int i = 0; i < 10; i ++)
            System.out.println(strs.delMin());
    }
}
