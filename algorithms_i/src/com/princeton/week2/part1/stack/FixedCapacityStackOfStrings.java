package com.princeton.week2.part1.stack;

public class FixedCapacityStackOfStrings {
    private String[] s;
    private int ptr = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public boolean isFull(){
        return ptr == s.length;
    }

    public void push(String item){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        s[ptr++] = item;
    }

    public String pop(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return null;
        }
        String item = s[ptr - 1];
        s[--ptr] = null;
        return item;
    }

    public String peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return null;
        }
        return s[ptr-1];
    }
}
