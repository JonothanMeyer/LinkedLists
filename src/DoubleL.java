
/**
 * Program name: Linked Lists: Class for the doubly linked list operations 
 * Author: Jonothan Meyer
 * Date: 2/20/18
 *
 *
 *  Description: This class handles everything dealing with doubly linked lists with head and 
 *  tail reference. All the methods and operations if the user chooses to use a singly linked list.
 *  Input/Output: Input is from users. All input comes from the driver class, fed to the parameters in this class. Screen output
 *  Assumptions and Limitations: All input will be doubles
 *  References and Sources: See: Driver Class
 */

public class DoubleL
{
 private Node head = null; //head of list
 private Node tail = null; //tail of list
 private int counter = 0;  
 private class Node {
   private double data;
   private Node next;
   private Node previous;
  Node()
  {
   this.data = data;
   //counter ++;
    } //end default constructor
   
   Node(double data)
   {
     //default constructor;
     this.data = data;
     this.next = null;
     this.previous = null;
     counter ++;
    } //end constructor 
    } //end class Node

 public void printList()
 { //print the entire list
   //System.out.println("now in printList method");
    if (isEmpty())
    {
     System.out.println("head > null < tail");
     counter = 0;
    }
    else if (head == tail)
    {
     System.out.println("head > " + head.data + " < tail");
     counter = 1;
    }
    else {
    System.out.print("head ");
    Node current = head;
    while (current != null) {
    System.out.print(" > " + current.data);
    current = current.next;
    }
    System.out.println(" < tail\n");
    }
     System.out.println();
    }
    
 public boolean isEmpty() 
 {
     //check to see that the list is empty
     return head == null ;
    }
    
 public void checkSize()
 {
  System.out.println("List size: " + counter);
 }

 public void addEnd(double data)
 {
     //add item to the end of a singly linked list
     //System.out.println("Now in addEnd method);
    if (isEmpty())
    {
    head = tail = new Node(data);
    head.next = tail;
    tail.previous = head;
    counter = 1;
    }
    else if (head == tail) {
    Node temp = new Node(data);
    tail = temp;
    tail.previous = head;
    head.next = tail;
    counter = 2;
    }
    else {
    Node temp = new Node(data);
    Node lastTail = tail;
    lastTail.next = temp;
    tail = temp;
    tail.previous = lastTail;
    //lastTail.next = tail;
    
    }
    printList();
    }
    
 public void clear()
 { 
     //this method will clear a singly linked list
     //System.out.println("Now in clear method");
     if (isEmpty())
     {
         System.out.println("The list is already empty");
        }
     if (head == tail)
     {
         head = null;
         tail = null;
         System.out.println("The only item in the list has been cleared");
        }
     else {
    head = head.next;
     while (head != null)
     {
    head = head.next;
    }
    tail = null;
    counter = 0;
    System.out.println("List Cleared");
    }
    printList();
  }

  public void insertPos(double data, int position)
  {
    //System.out.println("Now in insertPos method");
    position--;
    if (isEmpty() == true)
     { 
       System.out.println("The list is empty, new Node at position 1");  
       Node temp = new Node(data);
       head = tail = temp;
       head.previous = null;
       tail.next = null;
       head.next = tail;
       tail.previous = head;
       counter = 1;
        }
    else if (head == tail) {
      if (position == 1)
      {
      addHead(data);
        }
      else {
      addEnd(data);   
        }
    }   
    else if (counter < position){
    System.out.println("There are not that many nodes for your list, New node entered at end of list (position: " + counter + ")");
    addEnd(data); 
    }
    else {
    Node temp = new Node(data);
    Node traveler = new Node();
    Node otherInfo = new Node(data);
    traveler = head;
    for (int i = 0; i < position; i++) {
    otherInfo = traveler;
    traveler = traveler.next;
    }
    otherInfo.next = temp;
    temp.next = traveler;
    traveler.previous = temp;
    temp.previous = otherInfo;
    
    }
    printList();
  }
  

 
  public void insertInOrder(double data)
  {
   //System.out.println("Now in insertInOrder method");
   if (isEmpty())
     { 
       System.out.println("First Node at position 1");  
       head = tail = new Node(data);
       head.previous = null;
       head.next = tail;
       tail.previous = head;
       counter = 1;
        }
    else if (counter == 1) {
      
      if (data >= head.data) {
      addEnd(data);
      //counter++;
      }
      else {
      addHead(data);    
        }
    }
   boolean sorted = isSorted();
   if (sorted == true) {
       if (data <= head.data) {
       addHead(data);
        }
       else if (data >= tail.data) {
       addEnd(data);   
        }
       else {
      
       Node temp = new Node(data);
       Node other = new Node();
       Node current = new Node();
       current = head;
       while (current.data <= temp.data) {
       other = current;
       current = current.next;   
        }
       other.next = temp;
       temp.next = current;
       temp.previous = other.previous;
        }
       
       
    } // end of of if statment
    else {
    System.out.println("Since the data is not sorted, cannot insert new data in assending order"); 
    }
     printList();
  }

 public void printReverse()
 { 
    //System.out.println("Now in printReverse() method");
    if (isEmpty())
    {
     System.out.println("head > null < tail");
    }
    else if (head == tail)
    {
     System.out.println("head > " + head.data + " < tail");   
    }
    else {
    System.out.print("tail ");
    Node current = tail;
    while (current != head.previous) {
    System.out.print(" > " + current.data);
    current = current.previous;
    }
    System.out.println(" < head");
    }
    System.out.println();
 }
 
 public void addHead(double data)
 {
     //add item to the head of a singly linked list
    //System.out.println("Now in addHead method");
    if (isEmpty() == true)
     { 
       Node temp = new Node(data);
       head = tail = temp;
       tail.next = null;
       head.previous = null;
        }
    else if (head == tail) {
      Node temp = new Node(data);
      head = temp;
      head.next = tail;
      tail.previous = head;
      head.previous = null;
      tail.next= null;
    }
     else {
     Node newHead = new Node(data);
     Node lastHead = head;
     head = newHead;
     head.next = lastHead;
     lastHead.previous = head;
    }
    printList();
    }
    
 public boolean isSorted()
 {
     //this will check to see if the singly linked list is sorted
     //System.out.println("Now in isSorted method");
     boolean sorted = true;
         if (isEmpty() == true)
     { System.out.println("The list is empty");
        }
     else if (head == tail)
     { System.out.println("There is only one value in the list");
       
        }
     else {
      Node current = head;
      Node theNext = new Node();
      theNext = current.next;
      
      do
      {
        if (current.data <= theNext.data)
        {
        //keep sorted as true
        }
        else {
        sorted = false;
        }
        current = current.next;
        theNext = current.next;
    } while (theNext != null);
    
    System.out.println("list sorted: " + sorted);
   } //end of else
    return sorted;
  }

 public void deleteTail()
 {  
    //System.out.println("Now in deleteTail() method");
    if (isEmpty() == true)
     { 
       System.out.println("The List is empty");
        }
    else if (head == tail) {
     head = null;
     tail = null;
    }
     else {
     Node newTail = new Node();
     newTail = tail.previous;
     newTail.next = null;
     tail = newTail;
    }
    counter--;
    printList();
 }
 
 public void deleteHead()
 {
    //System.out.println("Now in deleteHead() method");
    if (isEmpty() == true)
     { 
       System.out.println("The List is empty");
        }
    else if (head == tail) {
     head = null;
     tail = null;
    }
     else {
     Node newHead = new Node();
     newHead = head.next;
     newHead.previous = null;
     head = newHead;
    }
    counter--;
    printList();
    }
    
 public void average()
 {
    double sum = 0;
    if (isEmpty())
    {
     System.out.println("The sum, and average is 0");
    }
    else if (head == tail)
    {
     System.out.println("The sum, and average is " + head.data);   
    }
    else {
    Node current = head;
    while (current != null) {
    sum += current.data;
    current = current.next;
    }
     System.out.println("Sum: " + sum);  
     System.out.println("Average: " + (sum/counter));
    }
    }
    
 //-------------------------------------------------------------------TESTING---------------------------------------------------------------------------------------------------
 
 public static void main (String[] args) //Driver
 {
     DoubleL a = new DoubleL();
     a.addEnd(15);
     a.addEnd(20);
     //a.clear();
     a.addEnd(30);
     //a.addHead(100);
     a.addHead(222);
     a.addHead(115);
     a.addHead(100);
     //a.isSorted();
     a.checkSize();
     a.insertPos(666, 20);
     a.insertInOrder(200);
     a.insertInOrder(50);
     a.addEnd(400);
     //a.clear();
     //a.addEnd(40);
     a.printReverse();
     a.addEnd(50);
     a.average();
     //a.deleteTail();
     //a.deleteHead();
     
     
    }
}
