package Queue;

import Stack.MyStack;

public class MyQueue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public MyQueue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void getFirst() {
        System.out.println("First in Queue: " + first.value);
    }

    public void getLast() {
        System.out.println("Last in Queue: " + last.value);
    }

    public void getLength() {
        System.out.println("Length of Queue: " + length);
    }

    public void printQueue() {
        Node temp = last;
        for(int i = 0; i < length; i++) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            first = newNode;
            last = newNode;
        }
        last.next = newNode;
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if(length == 0) {
            return null;
        }
        Node temp = first;

        if(length == 1) {
            first = null;
            last = null;
        }
        if(length > 1) {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
