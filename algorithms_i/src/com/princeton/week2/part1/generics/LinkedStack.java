package com.princeton.week2.part1.generics;

import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T> {
    private Node first;
    private class Node{
        T item;
        Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void reset(){
            current = first;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(T item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public T pop(){
        T item = first.item;
        first = first.next;
        return item;
    }
}
