A LinkedList is a sequence of Node objects. 

The Nodes possess at data field(s) and at least one pointer that references the next and, in some cases, the previous Node, 
if there is one.

Disadvantages:

    The elements (the Nodes) of a LinkedList must be iterated upon for reading, writing, and deleting nodes.

Advantages:

    Nodes may be added and removed to the front of the list in constant O(1) time complexity.
    They are resized dynamically every time a node is added.


The LinkedList class wraps the nodes and acts as a manager of nodes.