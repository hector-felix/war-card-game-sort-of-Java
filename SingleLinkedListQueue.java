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
public class SingleLinkedListQueue {

    protected Node front, rear;
    public int size;
 
    public SingleLinkedListQueue()
    {
        front = null;
        rear = null;
        size = 0;
    }    

    public boolean isEmpty()
    {
        return front == null;
    }    

    public int getSize()
    {
        return size;
    }    
 
    public void insert(int data)
    {
        Node nptr = new Node(data, null);
        if (rear == null)
        {
            front = nptr;
            rear = nptr;
        }
        else
        {
            rear.setLink(nptr);
            rear = rear.getLink();
        }
        size++ ;
    } 
    
    public void insert(Object data)
    {
        Node nptr = new Node(data, null);
        if (rear == null)
        {
            front = nptr;
            rear = nptr;
        }
        else
        {
            rear.setLink(nptr);
            rear = rear.getLink();
        }
        size++ ;
    }
    

    public Object remove() //Remove from front
    {
        if (isEmpty() ) {
            System.out.println("Error - Queue Empty");
        }
        Node ptr = front;
        front = ptr.getLink();        
        if (front == null)
            rear = null;
        size--;        
        return ptr.getData();
    }
    
    public Object peek()
    {
        if (isEmpty()) {
            System.out.println("Error - Queue Empty");
        }
//        if (isEmpty()) {
//            return null;
//        }
        return front.getData();
    }    

    public void printQueue()
    {
        //eSystem.out.print("\nQueue = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = front;
        while (ptr != rear.getLink() )
        {
            System.out.print(ptr.getData()+"\n");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
}