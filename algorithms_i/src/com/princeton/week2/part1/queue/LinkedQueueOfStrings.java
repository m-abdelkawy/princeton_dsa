package com.princeton.week2.part1.queue;

public class LinkedQueueOfStrings {
    private Node first, last;
    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(String item){
        Node oldLast = last;
        last = new Node();
        last.item = item;

        if(isEmpty()){
            first = last;
        }else{
            oldLast.next = last;
        }
    }

    public String dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty!");
            return null;
        }
        String item = first.item;
        first = first.next;
        return item;
    }
}
