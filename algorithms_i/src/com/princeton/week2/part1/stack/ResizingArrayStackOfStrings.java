package com.princeton.week2.part1.stack;

import java.util.Arrays;

public class ResizingArrayStackOfStrings {
    private String[] s;
    private int ptr = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return ptr == 0;
    }

    public void push(String item) {
        if (ptr == s.length) {
            resize(2 * s.length);
        }
        s[ptr++] = item;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return null;
        }

        String item = s[--ptr];
        s[ptr] = null;

        if (!isEmpty() && ptr == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        System.arraycopy(s, 0, temp, 0, Math.min(capacity, s.length));
        s = temp;
    }

    @Override
    public String toString() {
        return "ResizingArrayStackOfStrings{" +
                "s=" + Arrays.toString(s) +
                '}';
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        stack.push("1");
        System.out.println(stack.toString());
        stack.push("2");
        System.out.println(stack.toString());
        stack.push("3");
        System.out.println(stack.toString());
        stack.push("4");
        System.out.println(stack.toString());
        stack.push("5");
        System.out.println(stack.toString());
        stack.push("6");
        System.out.println(stack.toString());
        stack.push("7");
        System.out.println(stack.toString());
        stack.push("8");
        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());

    }
}
