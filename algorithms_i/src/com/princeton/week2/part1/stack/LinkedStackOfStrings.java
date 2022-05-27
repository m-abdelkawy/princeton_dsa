package com.princeton.week2.part1.stack;

/**
 * Linked List implementation for stack of strings
 * all operations take constant time, i.e, O(1)
 * @author Mohammed Abdelkawy
 */
public class LinkedStackOfStrings {
    private Node first;

    private class Node {
        String item;
        Node next;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        if(isEmpty()){
            return null;
        }
        String item = first.item;
        first = first.next;
        return item;
    }

    public String peek() {
        return isEmpty() ? null : first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
