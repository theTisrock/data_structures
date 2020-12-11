package linked_lists;

public class Driver {

    public static void main(String[] args) {

        // adding and appending
        LinkedList list = new LinkedList();
        System.out.println("List: " + list);

        System.out.println("Adding 1, 33, and 44 ...");
        list.add(1);  // [1]
        list.add(33);  // [33, 1]
        list.add(44);  // [44, 33, 1]

        System.out.println("List: " + list);

        System.out.println("Appending 55...");
        list.append(55);  // [44, 33, 1, 55]
        System.out.println("List: " + list);

        System.out.println("\nBegin reading values...");

        System.out.println("Getting value at position 1");
        int val = list.value_at(1);
        System.out.println("Position 1 value: " + val);

        System.out.println("Getting value at position 0");
        val = list.value_at(0);
        System.out.println("Position 0 value: " + val);

        System.out.println("Getting value at position 3");
        val = list.value_at(3);
        System.out.println("Position 3 value: " + val);

        System.out.println("Getting value at position 4");
        val = list.value_at(4);

        System.out.println("\nStarting pop/delete sequence...");
        System.out.println("List: " + list);
        System.out.println("Popping front value...");
        val = list.pop_front();
        System.out.println("Popped value at front " + val);
        System.out.println("List: " + list);

        System.out.println("Popping value 55 at end...");
        val = list.pop();
        System.out.println("Popped " + val);
        System.out.println("List: " + list);

        System.out.println("Appending 55 and 44 to the list...");
        list.append(55);
        list.append(44);
        System.out.println("List: " + list);

        System.out.println("Now popping value 55 at position 2");
        val = list.pop_at(2);
        System.out.println("Popped " + val);
        System.out.println("List: " + list);

        System.out.println("Try to pop non-existent value.");
        list.pop_at(10);
        System.out.println("Error message should print above this line.");

    }
}
