package com.si.structure;


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * BSTBean - a POJO to play with BST.
 * @param <Key>
 * @param <Value>
 */
public class BSTBean<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;            // sorted by Key
        private Value val;        // associated data
        private Node left, right;   // left and right sub trees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Constructor - Initializes an empty BST
     */
    public BSTBean() {
    }

    public void put(Key key, Value val) {
        // check to ensure the key specified is not null.
        if (key == null) {
            throw new NullPointerException("First argument to put() is null.");
        }
        root = put(root, key, val);
        // TODO: take a look at assert!
        //assert check();
    }

    private Node put(Node n, Key key, Value val) {
        // if the current BST is empty, create new root and return
        if (n == null) {
            return new Node(key, val);
        }

        // compare keys between the one we want to put and the current passed in Node
        int cmp = key.compareTo(n.key);

        if (cmp < 0) {
            n.left = put(n.left, key, val);
        } else if (cmp > 0) {
            n.right = put(n.right, key, val);
        } else {
            n.val = val;
        }

        return n;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }


    ////////////////////////////////////////////////////////////////
    // Minimium
    ////////////////////////////////////////////////////////////////

    public void min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Called min() with empty BST.");
        }

        Node n = min(root);
        System.out.println("Node with the Minimium Value");
        System.out.println("-----------------------------");
        System.out.println(n.key + ": " + n.val);
        System.out.println("-----------------------------");
    }

    private Node min(Node n) {
        if (n.left != null) {
            return min(n.left);
        }
        return n;
    }

    ////////////////////////////////////////////////////////////////
    // Maxium
    ////////////////////////////////////////////////////////////////

    public void max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Called max() with empty BST.");
        }

        Node n = max(root);
        System.out.println("Node with the Maximium Value");
        System.out.println("-----------------------------");
        System.out.println(n.key + ": " + n.val);
        System.out.println("-----------------------------");
    }

    private Node max(Node n) {
        if (n.right != null) {
            return max(n.right);
        }
        return n;
    }


    ////////////////////////////////////////////////////////////////
    // Pre Order Depth First Search
    ////////////////////////////////////////////////////////////////

    public void preOrderDFS() {
        System.out.println("Pre Order Depth First Search");
        System.out.println("-----------------------------");
        preOrderDFS(root);
        System.out.println("-----------------------------");
    }

    private void preOrderDFS(Node n) {
        if (n == null) {
            return;
        }
        System.out.println(n.key + ": " + n.val);
        preOrderDFS(n.left);
        preOrderDFS(n.right);
    }

    ////////////////////////////////////////////////////////////////
    // In Order Depth First Search
    ////////////////////////////////////////////////////////////////

    public void inOrderDFS() {
        System.out.println("In Order Depth First Search");
        System.out.println("-----------------------------");
        inOrderDFS(root);
        System.out.println("-----------------------------");
    }

    private void inOrderDFS(Node n) {
        if (n == null) {
            return;
        }
        inOrderDFS(n.left);
        System.out.println(n.key + ": " + n.val);
        inOrderDFS(n.right);
    }

    ////////////////////////////////////////////////////////////////
    // Post Order Depth First Search
    ////////////////////////////////////////////////////////////////

    public void postOrderDFS() {
        System.out.println("Post Order Depth First Search");
        System.out.println("-----------------------------");
        postOrderDFS(root);
        System.out.println("-----------------------------");
    }

    private void postOrderDFS(Node n) {
        if (n == null) {
            return;
        }
        postOrderDFS(n.left);
        postOrderDFS(n.right);
        System.out.println(n.key + ": " + n.val);
    }

    ////////////////////////////////////////////////////////////////
    // Breadth First Search
    ////////////////////////////////////////////////////////////////

    public void BFS() {
        System.out.println("Breadth First Search");
        System.out.println("-----------------------------");
        BFS(root);
        System.out.println("-----------------------------");
    }

    public void BFS(Node n){
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.key + ": " + node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    ////////////////////////////////////////////////////////////////
    // Validate
    ////////////////////////////////////////////////////////////////

    public boolean isBST() {
        boolean rtnValue = false;
        System.out.println("Breadth First Search");
        System.out.println("-----------------------------");
        rtnValue = isBST(root, null, null);
        System.out.println("-----------------------------");
        return rtnValue;
    }

    private boolean isBST(Node n, Key min, Key max) {
        if (n == null)
            return true;
        if (min != null && n.key.compareTo(min) <= 0)
            return false;
        if (max != null && n.key.compareTo(max) >= 0)
            return false;
        return isBST(n.left, min, n.key) && isBST(n.right, n.key, max);
    }
}
