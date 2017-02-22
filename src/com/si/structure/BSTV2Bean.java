package com.si.structure;

public class BSTV2Bean {

    private Node root;

    private class Node {
        private int key;
        Node right, left;

        public Node(int key) {
            this.key = key;
        }
    }

    public BSTV2Bean() {
    }

    public void put(int key) {
        root = put(root, key);
    }

    private Node put(Node n, int k) {
        if (n == null) {
            return new Node(k);
        }

        if (n.key < k) {
            n.left = put(n.left, k);
        } else if (n.key > k) {
            n.right = put(n.right, k);
        } else {
            n.key = k;
        }

        return n;
    }




    public void output() {
        System.out.println("Output!");
        System.out.println("---------------------------");
        output(root);
        System.out.println("---------------------------");
    }

    private void output(Node n) {
        // check for null node, return so we do not try to access it;
        if (n == null) {
            return;
        }

        output(n.left);
        System.out.println(n.key);
        output(n.right);
    }

}
