package com.princeton.week2.part1.queue;

public class ArrayQueueOfStrings {
    String[] q;
    int head, tail;

    public ArrayQueueOfStrings(int size) {
        q = new String[size];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail == q.length;
    }

    public void enqueue(String item) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        q[tail++] = item;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return null;
        }
        String item = q[head];
        for (int i = 0; i < tail-1; i++) {
            q[i] = q[i+1];
        }
        q[--tail] = null;
        return item;
    }


    public static void main(String[] args) {

    }
}
