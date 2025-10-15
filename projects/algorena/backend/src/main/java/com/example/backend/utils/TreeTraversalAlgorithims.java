package com.example.backend.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    String val;
    Node left, right;

    Node(String val) {
        this.val = val;
        left = right = null;
    }
}

public class TreeTraversalAlgorithims {

    // Build tree and measure time
    public static Node buildTree(List<String> lists) {
        long startTime = System.nanoTime();
        if (lists == null || lists.isEmpty() || lists.get(0).equals("null")) {
            return null;
        }

        Node root = new Node(lists.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        int size = lists.size();

        while (i < size) {
            Node current = q.poll();

            // Left child
            if (i < size && !lists.get(i).equals("null")) {
                current.left = new Node(lists.get(i));
                q.add(current.left);
            }
            i++;

            // Right child
            if (i < size && !lists.get(i).equals("null")) {
                current.right = new Node(lists.get(i));
                q.add(current.right);
            }
            i++;
        }
        long endTime = System.nanoTime();
        double buildTimeMillis = (endTime - startTime) / 1_000_000.0;
        System.out.println(String.format("Tree built in %.3f ms", buildTimeMillis));
        return root;
    }

    // Preorder Traversal
    public static String preorderTraversal(List<String> lists) {
        List<String> result = new ArrayList<>();
        int[] steps = { 0 };
        long buildStart = System.nanoTime();
        Node root = buildTree(lists);
        long buildEnd = System.nanoTime();
        double buildTimeMillis = (buildEnd - buildStart) / 1_000_000.0;

        long startTime = System.nanoTime();
        preOrder(root, result, steps);
        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        return formatTraversalResult("Preorder", result, steps[0], buildTimeMillis, durationMillis);
    }

    private static void preOrder(Node node, List<String> result, int[] steps) {
        if (node == null)
            return;
        steps[0]++;
        result.add(node.val);
        preOrder(node.left, result, steps);
        preOrder(node.right, result, steps);
    }

    // Inorder Traversal
    public static String inorderTraversal(List<String> lists) {
        List<String> result = new ArrayList<>();
        int[] steps = { 0 };
        long buildStart = System.nanoTime();
        Node root = buildTree(lists);
        long buildEnd = System.nanoTime();
        double buildTimeMillis = (buildEnd - buildStart) / 1_000_000.0;

        long startTime = System.nanoTime();
        inOrder(root, result, steps);
        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        return formatTraversalResult("Inorder", result, steps[0], buildTimeMillis, durationMillis);
    }

    private static void inOrder(Node node, List<String> result, int[] steps) {
        if (node == null)
            return;
        inOrder(node.left, result, steps);
        steps[0]++;
        result.add(node.val);
        inOrder(node.right, result, steps);
    }

    // Postorder Traversal
    public static String postorderTraversal(List<String> lists) {
        List<String> result = new ArrayList<>();
        int[] steps = { 0 };
        long buildStart = System.nanoTime();
        Node root = buildTree(lists);
        long buildEnd = System.nanoTime();
        double buildTimeMillis = (buildEnd - buildStart) / 1_000_000.0;

        long startTime = System.nanoTime();
        postOrder(root, result, steps);
        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;

        return formatTraversalResult("Postorder", result, steps[0], buildTimeMillis, durationMillis);
    }

    private static void postOrder(Node node, List<String> result, int[] steps) {
        if (node == null)
            return;
        postOrder(node.left, result, steps);
        postOrder(node.right, result, steps);
        steps[0]++;
        result.add(node.val);
    }

    // Helper to format traversal output
    private static String formatTraversalResult(String type, List<String> result, int steps, double buildTime,
            double traversalTime) {
        StringBuilder sb = new StringBuilder();
        sb.append("🔹 ").append(type).append(" Traversal\n");
        sb.append("---------------------------------\n");
        sb.append("Tree Build Time: ").append(String.format("%.3f ms\n", buildTime));
        sb.append("Traversal Steps (Nodes Visited): ").append(steps).append("\n");
        sb.append("Traversal Execution Time: ").append(String.format("%.3f ms\n", traversalTime));
        sb.append("Traversal Result: ").append(String.join(" → ", result)).append("\n");
        return sb.toString();
    }
}
