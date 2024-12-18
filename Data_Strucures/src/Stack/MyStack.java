package Stack;

public class MyStack {
    private Node top;
    private int height;
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }



    public MyStack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void getTop() {
        System.out.println("Top of Stack: " + top.value);
    }

    public void getHeight() {
        System.out.println(("Height of stack: " + height));
    }

    public void printStack() {
        Node temp = top;
        for(int i = 0; i < height; i++) {
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        Node temp = top;
        if(height == 0) {
            return null;
        } else {
            top = top.next;
            temp.next = null;
            height--;
        }
        return temp;
    }


}
