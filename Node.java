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
public class Node {
    Object data;
    //Object data;
    //link
    Node next;
   
    private Node link;
    
    // Constructors
    // Default Constructor
    public Node (Object data) {
        this.data = data;       // Assign the given date
        this.next = null;       // By default there is no next node
    }
    
    // Overloaded Constructor
    // Created a node and points it to another node
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    public void setLink(Node n)
    {
        link = n;
    }
    
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public Object getData()
    {
        return data;
    }
    
    
}
