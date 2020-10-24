package Strs;

import java.util.LinkedList;
import java.util.Queue;

public class TrieST<Val>
{
    private static final int R = 256;
    private Node root;

    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];
    }

    @SuppressWarnings("unchecked")
    public Val get(String key)
    {
        Node node = get(root, key, 0);
        if (node == null)
            return null;
        return (Val) node.val;
    }

    private Node get(Node node, String key, int d)
    {
        if (node == null)
            return null;

        if (d == key.length())
            return node;
        else
            return get(node.next[key.charAt(d)], key, d + 1);
    }

    public void put(String key, Val val)
    {
        root = put(root, key, val, 0);
    }

    private Node put(Node node, String key, Val val, int d)
    {
        if (node == null)
            node = new Node();

        if (d == key.length())
            node.val = val;
        else
            node.next[key.charAt(d)] =
                    put(node.next[key.charAt(d)], key, val, d + 1);

        return node;
    }

    public void delete(String key)
    {
        root = delete(root, key, 0);
    }

    private Node delete(Node node, String key, int d)
    {
        if (node == null)
            return null;

        if (d == key.length())
            node.val = null;
        else
            node.next[key.charAt(d)] = delete(node.next[key.charAt(d)], key, d + 1);

        if (node.val != null)
            return node;
        else
            for (int c = 0; c < R; c ++)
                if (node.next[c] != null)
                    return node;

        return null;
    }

    public Iterable<String> keys()
    {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre)
    {
        Queue<String> q = new LinkedList<>();
        collect(root, pre, q);
        return q;
    }

    private void collect(Node node, String pre, Queue<String> q)
    {
        if (node == null)
            return;

        if (node.val != null)
            q.offer(pre);

        for (char c = 0; c < R; c ++)
            collect(node.next[c], pre + c, q);
    }

    public Iterable<String> keysThatMatch(String pat)
    {
        Queue<String> q = new LinkedList<>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node node, String pre, String pat, Queue<String> q)
    {
        if (node == null)
            return;

        int d = pre.length();
        if (d == pat.length() && node.val != null)
            q.offer(pre);
        if (d == pat.length())
            return;

        char p = pat.charAt(d);
        for (char c = 0; c < R; c ++)
            if (p == '.' || p == c)
                collect(node.next[c], pre + c, pat, q);
    }

    public static void main(String[] args)
    {
        TrieST<Integer> st = new TrieST<>();
        st.put("fuck", 10);
        System.out.println(st.get("fuck"));
        st.delete("fuck");
        System.out.println(st.get("fuck"));
    }
}
