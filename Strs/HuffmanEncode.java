package Strs;

import sort.PriorityQueue;

import java.io.*;
import java.util.*;

public class HuffmanEncode
{
    private static int R = 256;

    public static void compress()
    {
        String s = In.read();
        char[] input = s.toCharArray();

        int[] freq = new int[R];
        for (int c : input)
            freq[c] ++;

        // build a tree
        Node root = buildTrie(freq);

        // build a table
        String[] st = new String[R];
        buildCode(st, root, "");

        // syso trie
        writeTire(root);
        System.out.print(Integer.toBinaryString(input.length));

        StringBuilder builder = new StringBuilder();
        // compress
        for (char c : input)
            builder.append(st[c]);

        String code = builder.toString();
        System.out.println(code);
        System.out.println(code.length() / (input.length * 16.0));
    }

    private static void writeTire(Node node)
    {
        if (node == null)
            return;

        if (node.isLeaf())
        {
            System.out.print(Integer.toBinaryString((byte) 1));
            System.out.print(Integer.toBinaryString(node.c));
            return;
        }

        System.out.print((byte) 0);
        writeTire(node.left);
        writeTire(node.right);
    }

    private static void buildCode(String[] st, Node node, String s)
    {
        if (node.isLeaf())
        {
            st[node.c] = s;
            return;
        }

        buildCode(st, node.left, s + '0');
        buildCode(st, node.right, s + '1');
    }

    private static Node buildTrie(int[] freq)
    {
        java.util.PriorityQueue<Node> pq = new java.util.PriorityQueue<>();
        for (char c = 0; c < R; c ++)
            if (freq[c] > 0)
                pq.offer(new Node(c, freq[c], null, null));

        while (pq.size() > 1)
        {
            Node x = pq.poll();
            Node y = pq.poll();

            Node p = new Node('\0', x.freq + y.freq, x, y);
            pq.offer(p);
        }

        return pq.poll();
    }

    public static void main(String[] args)
    {
        compress();
    }

    private static class Node implements Comparable<Node>
    {
        private char c;
        private int freq;
        private final Node left, right;

        Node(char c, int freq, Node left, Node right)
        {
            this.left = left;
            this.right = right;
            this.c = c;
            this.freq = freq;
        }

        boolean isLeaf()
        {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node o)
        {
            return this.freq - o.freq;
        }
    }
}
