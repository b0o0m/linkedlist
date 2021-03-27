import java.util.*;

public class linkedList {
    Node head;
    private int middleElement;
    private int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int getMiddleElement() {
        return middleElement;
    }

    public void setMiddleElement(int middleElement) {
        this.middleElement = middleElement;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        setSize(count);
        return count;
    }

    public int get(int index) {
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null) {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
        return 0;
    }

    public void removeIndex(int i) {
        Node temp = head;
        Node previos = null;

        // If head node was the input
        if (temp != null && temp.data == i) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != i) {
            previos = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        previos.next = temp.next;
    }

    public void addFirst(int k) {
        Node new_node = new Node(k);
        new_node.next = head;
        head = new_node;
    }

    public void add(int k) {

        Node new_node = new Node(k);

        if (head == null) {
            head = new Node(k);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
    }
    public void print()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public void middleSize() {
        if (size() % 2 == 0) {
            setSize((size() / 2) - 2);
        } else if (size() % 2 != 0) {
            setSize(size() / 2);
        }
    }

    public void findMiddle() {
        middleSize();
        setMiddleElement(get(size));
        size() ;
    }

    public void removeMiddle() {
        middleSize();
        removeIndex(getSize());
        size() ;
    }

    public void contains(Node head, int x)
    {
        int index = 0  ;
        Node current = head;    //Initialize current
        while (current != null)
        {
            if (current.data == x)
                System.out.println(index);    //data found
            current = current.next;
            index += 1 ;
        }
        System.out.println(-1);
    }
}

