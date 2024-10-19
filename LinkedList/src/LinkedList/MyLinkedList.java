package LinkedList;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    public MyLinkedList(int value) {
        //create a new node
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        //create a new node
        //add node to beginning
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
//            Node temp = head.next;
//            head = newNode;
//            head.next = temp;
            //OR
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public boolean insert(int index, int value) {
        //create new node
        ///insert Node
        return true;
    }

    public Node removeLast() {
        if(length == 0) {
            return null;
        }
        Node temp = head;
        Node prev = head;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst() {
        if(length == 1) {
            head = null;
            tail = null;
        }
        if(length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index) {
        if(length == 0 || index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
