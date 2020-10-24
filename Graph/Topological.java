package Graph;

public class Topological
{
	private Iterable<Integer> order;
	
	public Topological(Digraph G)
	{
		DirectedCycle cycleFinder = new DirectedCycle(G);
		if (!cycleFinder.hasCycle())
		{
			order = new DFOrder(G).reverseOrder();
		}
	}
	
	public Iterable<Integer> order()
	{
		return order;
	}
	
	public static void main(String[] args)
	{
		Digraph G = new Digraph(new In("C:\\Users\\18069\\Desktop\\data.txt"));
		
		System.out.println(new Topological(G).order());
	}
}
