package com.princeton.week2.part1.assignment;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int head = 0, tail;

    private class RandomIterator implements Iterator<Item> {
        private final int[] indexes = new int[tail-head];
        private int current = head;

        public RandomIterator() {
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = i;
            }
            StdRandom.shuffle(indexes);
        }

        @Override
        public boolean hasNext() {
            return current < tail;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return queue[indexes[current++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        return tail - head;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        queue[tail++] = item;
        if (tail == queue.length) {
            resize(2 * queue.length);
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(head, tail);

        Item item = queue[random];

        queue[random] = queue[--tail];

        if (tail == queue.length / 4) {
            resize(queue.length / 2);
        }

        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(head, tail);

        return queue[random];
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(queue, 0, temp, 0, Math.min(capacity, size()));
        queue = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(4);
        queue.iterator();
        queue.iterator();
    }
}
