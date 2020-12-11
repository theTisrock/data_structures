package linked_lists;

public class LinkedList {
    // instance fields
    Node head;
    int length;

    // constructors
    public LinkedList() {
        length = 0;
        head = null;
    }

    private boolean is_empty() {
        return head == null;
    }

    private boolean bad_insert_index(int index) {
        boolean result =  index > length || index < 0;

        if (result)
            System.out.println("The supplied index " + index + " exceeds the length of the list");

        return result;
    }

    /* writing */
    public void add(int data) {
        // adds an element to the beginning of the list
        this.insert(data, 0);
    }

    public void append(int data) {
        // adds an element to the end of the list instead of the beginning
        this.insert(data, length);
    }

    public void insert(int data, int at) {
        /* imperative implementation for declarative use in add and append methods */
        boolean badIndex = this.bad_insert_index(at);

        if (badIndex)
            return;

        Node new_node = new Node(data);

        if (this.is_empty()) {
            head = new_node;
            head.next = null;
        }

        else {
            if (at == 0) { // insert at the front
                Node temp = new_node;
                temp.next = head;
                head = temp;
            }
            else if (at == length) { // insert at the end
                Node current = head;

                while (current != null) {
                    boolean current_is_last = current.next == null;
                    if (current_is_last) {
                        current.next = new_node;
                        break;
                    }
                    current = current.next;
                }
            }
            else if (at < length && at > 0) {  // insert in middle
                Node current = head;
                int index = 0;

                while (current != null) {
                    int next_index = index + 1;
                    boolean next_node_is_target = next_index == at;

                    if (next_node_is_target) {
                        Node temp = new_node;
                        temp.next = current.next;
                        current.next = temp;
                        break;
                    }

                    index = next_index;
                    current = current.next; // traverse the list
                }
            }
        }

        length = length + 1;
    }

    /* reading */
    public int value_at(int target) {
        int result = 0;
        Node cursor = head;
        int index = 0;

        while (cursor != null) {
            boolean current_is_last = cursor.next == null;

            if (index == target) {
                result = cursor.data;
                break;
            }
            else if (current_is_last) {
                // ideally, this would raise an exception
                System.out.println("No value for index " + target + ". Length is " + length);
            }

            index = index + 1;
            cursor = cursor.next;
        }

        return result;
    }

    /* deleting */
    public int pop_at(int at) {
        if (at >= length || at < 0)
            System.out.println("ERROR: cannot pop from a non-existent index");

        int result = 0;
        if (head == null) {
            System.out.println("Empty List");
            result = 0;
        }

        if (at == 0) {  // pop at the front
            result = head.data;
            head = head.next;
        }
        else {
            if (at == length - 1) {  // pop at end of list
                Node current = head;

                while (current != null) {
                    boolean one_before_last = current.next != null && current.next.next == null;
                    if (one_before_last) {
                        result = current.next.data;
                        current.next = null;  // deletes the node
                        break;
                    }
                    current = current.next;
                }
            }
            else if (at > 0 && at < length - 1) {  // pop in middle
                int target = at;
                Node current = head;
                int index = 0;

                while (current != null) {
                    boolean one_before_target = index == target - 1;

                    if (one_before_target) {
                        result = current.next.data;
                        current.next = current.next.next;
                        break;
                    }

                    current = current.next;
                    index = index + 1;
                }
            }
        }

        length = length - 1;

        return result;
    }

    public int pop_front() {
        return this.pop_at(0);
    }

    public int pop() {
        return this.pop_at(length-1);
    }

    /* convert */
    public int[] to_array() {

        int[] array = new int[length];

        Node cursor = head;
        int index = 0;

        while (cursor != null) {
            array[index] = cursor.data;
            cursor = cursor.next;
            index = index + 1;
        }

        return array;
    }

    public String toString() {
        String result = "[";

        Node current = head;

        while (current != null) { // if current is a Node and not null
            String element = result + current.data;
            boolean current_is_last = current.next == null;
            result = (current_is_last) ? element  : element + ", ";
            current = current.next;
        }

        result = result + "]";
        return result;
    }

}
