package com.princeton.week2.part1.assignment;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Dequeue. A double-ended queue or deque (pronounced “deck”) is a generalization of
 * a stack and a queue that supports adding and removing items from either
 * the front or the back of the data structure
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Deque() {
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;

        if(oldFirst == null){
            last = first;
        }else{
            oldFirst.previous = first;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
            first = null;
        } else {
            first.previous = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.previous;
        size--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;/////
        }
        return item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("BB");

    }
}
