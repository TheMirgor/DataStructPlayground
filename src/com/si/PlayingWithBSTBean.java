package com.si;


import com.si.structure.BSTBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class PlayingWithBSTBean {
    private String title = "Fun with Binary Search Trees";
    private BSTBean<Integer, String> bst = new BSTBean<>();

    public PlayingWithBSTBean() {
        bst.put(5, "test5");
        bst.put(2, "test2");
        bst.put(10, "test10");
    }

    public String getTitle() {
        return title;
    }

    public void setHello(String hello) {
        this.title = hello;
    }


    public void preOrderDFS() {
        bst.preOrderDFS();
    }

    public void inOrderDFS() {
        bst.inOrderDFS();
    }

    public void postOrderDFS() {
        bst.postOrderDFS();
    }

    public void BFS() {
        bst.BFS();
    }

    public void min() {
        bst.min();
    }

    public void max() {
        bst.max();
    }

}
