package com.si;

import com.si.structure.LinkedListBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class PlayingWithLLBean {
    private String title = "Fun with Linked Lists!";
    private LinkedListBean<Integer> ll = new LinkedListBean<>();

    public PlayingWithLLBean() {
        ll.add(5);
        ll.add(7);
        ll.add(2);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void traverse() {
        ll.traverse();
    }
}
