package com.princeton.week2.part1.generics;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T> {
    private T[] s;
    private int ptr;

    public ArrayStack() {
        this.s = (T[]) new Object[1];
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int current = ptr;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public T next() {
            return s[--current];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public void push(T item){
        if(ptr == s.length){
            resize(2 * s.length);
        }
        s[ptr++]=item;
    }

    public T pop(){
        T item = s[--ptr];
        s[ptr] = null;
        if(ptr == s.length/4){
            resize(s.length/2);
        }
        return item;
    }

    public T peek(){
        return s[ptr-1];
    }

    private void resize(int capacity) {
        T[] temp = (T[])new Object[capacity];
        System.arraycopy(s, 0, temp, 0, Math.min(capacity, s.length));
        s = temp;
    }
}
