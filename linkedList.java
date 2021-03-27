package com.example;


import java.util.*;

public class linkedList {

    // Fields 
    Node head;
    private int middleElement;
    private int size;
     
    // this is the node class 
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /* setter and getter */
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

     /**
     * This method returns the length of
     * linked list, and it fix the size field
     * @return count is the length of it
     */
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
    
    /**
    * This method give us the node 
    * by index
    */
    public int get(int index) {
        Node current = head;
        int count = 0; // index of current node 
        while (current != null) {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }
        return -1;
    }
    
    /**
    * This method removes node by index 
    * if it was's a valid input does nothing!
    * @parameter i is the input index
    */
    public void removeIndex(int i) {
        Node temp = head;
        Node previos = null;

        // If head node was the input
        if (temp != null && temp.data == i) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != i) {
            previos = temp;
            temp = temp.next;
        }

        // If key was not present in linkedlist
        if (temp == null)
            return;

        previos.next = temp.next;
    }
    
    /**
    * This method adds the input 
    * to first of the linkedList
    * @parameter k is the data to add 
    */
    public void addFirst(int k) {
        Node new_node = new Node(k);
        new_node.next = head;
        head = new_node;
    }
    
    
    
    /**
    * This method add the input 
    * to the last of linkedList
    * @parameter k is the node to add Last  
    */
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
    
    /**
    * This method print nodes 
    * of the linkedList
    */
    public void print()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
    
    /**
    * This method finds the middle 
    * index of a linked list
    */
    public void middleSize() {
        if (size() % 2 == 0) {
            setSize((size() / 2) - 2);
        } else if (size() % 2 != 0) {
            setSize(size() / 2);
        }
    }
    
    /**
    * This method sets middleElement field 
    */
    public void findMiddle() {
        middleSize();
        setMiddleElement(get(size));
        size() ;
    }
    
    /**
    * This method removes middleElement
    */
    public void removeMiddle() {
        middleSize();
        removeIndex(getSize());
        size() ;
    }

    /**
    * This method gets the input,if it
    * contians in linkedList it prints 
    * the index of it,else it prints -1
    */
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

