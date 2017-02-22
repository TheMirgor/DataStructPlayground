package com.si.structure;

public class LinkedListBean<Value extends Comparable<Value>> {
    private Node head;

    private class Node {
        private Value val;
        private Node next, prev;

        public Node(Value val) {
            this.val = val;
        }
    }

    public void add(Value val) {
        if (val == null) {
            throw new NullPointerException("First argument to add() is null.");
        }

        Node n = add(head, val);
        head = n;
    }

    private Node add(Node n, Value val) {
        if (n == null) {
            return new Node(val);
        }

        n.prev = add(n.prev, val);

        return n;
    }


    public void traverse() {
        System.out.println("Traverse");
        System.out.println("-----------------------------");
        traverse(head);
        System.out.println("-----------------------------");
    }


    private void traverse(Node n) {
        if (n == null) {
            throw new NullPointerException("First argument to traverse() is null.");
        }

        System.out.println(n.val + " ");
        if (n.next != null) {
            traverse(n.next);
        }
    }

}
