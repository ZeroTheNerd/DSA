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
        System.out.println("Remove First");
        ll.printList();

        ll.append(56);
        ll.append(8);
        System.out.println("List at current time");
        ll.printList();
        System.out.println("Node value at index 1");
        System.out.println(ll.get(1).value);
        System.out.println("Set 56 --> 9");
        ll.set(1, 9);
        ll.printList();
    }
}