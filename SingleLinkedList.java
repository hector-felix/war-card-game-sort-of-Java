/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc331proj03;

/**
 *
 * @author Hector Felix
 */
public class SingleLinkedList {
    
    Node head;                      // Head of the Linked List
    private int size;                       // How many nodes are there in the list
    
    // Constructor to create Linked List
    public SingleLinkedList() {
        this.head = new Node(null);         // This creates the head
        this.size = 0;                      // Initially there are no nodes in the list
    }
    
    // Method to add at the beginning of the Linked List
    public void addFirst(Object item) {
//        Node first = new Node(item);        // Creates the node
//        first.next = head.next;             // Copy the link from head
//        head.next = first;                  // Update the head.next pointer
        
        head.next = new Node(item, head.next);// One-line solution for above
        
        size++;                             //Increase the size
    }
    // Method to insert value after a node
    public void addAfter(Object item, Node target) {
        target.next = new Node(item, target.next);
        size++;
    }
    // For users to be able to use addAfter
    // Overload the addAfter method
    public void addAfter(Object item, int index) {
        System.out.println("NodeSize: "+size);
        System.out.println("NodeIndex: "+index);
        if (index < size && index >= 0) {
            
        addAfter(item, getNode(index));
        }
        else
            System.out.println("Invalid Index! " + item + " Not added");
        //size++;
    }
    
    //Method to insert at the end of the List
    public void addLast(Object item) {
        Node target = getNode(size);        //Get the reference of th elast node
        this.addAfter(item, target);        // Use the addAfter() method to insert
    }
    //helper method that gives you the reference
    private Node getNode(int index) {
        // Method returns the reference of the node at the index
        // First check if the index is valid or not
        if (index < 0 || index > size)
            return null;            // Invalid Index
        // Otherwise, we iterate over the list and return the reference
        Node iter = head;           // Iterator node
        for(int i = 0; i < index; i++) {
            iter = iter.next;       // Keep going to next Node
        }
        // At the end of the loop, you are pointing to the node at index
        return iter;
    }
    
    // toString method to print the contents of the linked list
    @Override
    public String toString() {
        String value = "";
        Node temp = head;       // This is the iterator to go over the Nodes
        while(temp.next != null)  {   // While there is still some node
            value += temp.next.data+ "\n" ;    // Get the Node Data
            temp = temp.next;
        }
        return value;
    }
    
    public int getSize() {
        return size;
    }
    
    public void printReverse() {
        if (size==0)
            return;
        printReverse(head.next);
    }
    
    void printReverse(Node current) 
    { 
        
        
        if(current.next == null) {
            System.out.print(current.data + " | ");
            return;
        }
        
        else {
            printReverse(current.next);
            //Once the later nodes are printed, then print current
            System.out.print(current.data + " | ");
        }
    } 
    
    // Method to remove data from the beginning of the List
    public Node removeFirst() {
        // Check if there is an object to remove
        if (size == 0)
            return null; //There is no data
        Node temp = head.next;          // Store in a temp reference to return
        head.next = head.next.next;     //Point the head to the second node or null
        size--;
        return temp;
    }
    
    public Node removeAfter(Node target) {
       Node temp = target.next;                 // This is the Node being deleted
       if (temp != null) {
           target.next = temp.next;
           size--;
       }
       else {
           return null;
       }
       return temp;
    }
    
    public Node removeAfter(int target) {
        Node temp = getNode(target);
        if(temp != null) {
            return removeAfter(temp);
        }
           return null;
    }
   
}
