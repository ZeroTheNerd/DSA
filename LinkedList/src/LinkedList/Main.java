package LinkedList;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList(3);

        ll.append(5);

        ll.removeLast();

       // ll.printList();

        ll.prepend(2);

        ll.printList();

        ll.removeFirst();
        System.out.println("Remove First - ");
        ll.printList();
    }
}