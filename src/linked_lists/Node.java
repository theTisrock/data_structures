package linked_lists;

public class Node {
    // instance fields, unless "static" keyword is used.
    Node next = null;
    int data;

    public Node(int d) { // constructor
        data = d;
    }

    public String toString() {
        return Integer.toString(data);
    }
}
