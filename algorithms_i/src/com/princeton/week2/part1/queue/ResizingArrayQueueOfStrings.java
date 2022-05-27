package com.princeton.week2.part1.queue;

public class ResizingArrayQueueOfStrings {
    private String[] q;
    private int head, tail;

    public ResizingArrayQueueOfStrings() {
        q = new String[1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(String item) {
        q[tail++] = item;

        if (tail == q.length) {
            resize(2 * q.length);
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty!");
            return null;
        }
        String item = q[head];
        for (int i = 0; i < tail - 1; i++) {
            q[i] = q[i + 1];
        }
        q[--tail] = null;
        if (tail == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        System.arraycopy(q, head, tail - 1, 0, tail - head);
        q = temp;
    }
}
