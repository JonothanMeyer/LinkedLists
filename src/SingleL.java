
/**
 * Program name: Linked Lists: Class for the singly linked list operations 
 * Author: Jonothan Meyer
 * Date: 2/12/18
 * 
 * Description: This class handles everything dealing with singly linked lists. All the methods and operations if the user chooses to use a singly linked list.
 * Input/Output: Takes user input, put into method parameters from Driver class.
 * Assumptions and Limitations: all input will be ints
 * Referances and Sources: See: Driver Class
 */

 public class SingleL
{
 Node head = null; //head of list
  int n = 0;
  private class Node {
  private int data;  
  private Node next;

   Node()
   {
   this.data = data; 
    }
    Node(int data) 
   {
    this.data = data;
    }
  
    }

 public void displayListOptions()
 {
    System.out.printf("%-50s\n%-25s\n%-25s\n%-25s\n%-25s\n%-25s\n%-25s\n%-25s", "Singly linked, no tail, non-circular list options:","1: Build a list",
    "2: Clear the list","3: Check if list is sorted", "4: Insert at head", "5: Insert at tail", "6: Count size of list", "0: Exit");
    }
    
 public void printList()
 { //print the entire list
   //System.out.println("now in printList method");
    if (isEmpty())
    {
     System.out.println("head > null");
    }
    else if (head.next == null)
    {
     System.out.println("head > " + head.data + " > null");   
    }
    else {
    System.out.print("head ");
    Node current = head;
    while (current != null) {
    System.out.print(" > " + current.data);
    current = current.next;
    }
    System.out.println(" > null");
    }
   System.out.println();
    }
    
 public boolean isEmpty() 
 {
     //check to see that the list is empty
     return head == null;
    }
    
 public void checkSize()
 {
     //for keeping track of the size of the list.
     //System.out.println("now in checkSize method");

     if (isEmpty()) {
     n = 0;
    }
    else if (head.next == null) {
     n = 1;
    }
        else {
    Node current = new Node();
    current = head.next;
    n++;
    while (current != null)
    {
    n++;
    current = current.next;
    }
    
   } // end if
   System.out.println("Size of the list: " + n);
}

 public void addEnd(int data)
 {
     //add item to the end of a singly linked list
     //System.out.println("Now in addEnd method");
     if (isEmpty() == true)
     { head = new Node(data);
        }
     else {
     Node current = head;
     while (current.next != null) {
         current = current.next;
        }
     current.next = new Node(data);
    }
    printList();
    }
 public void clear()
 { 
     //this method will clear a singly linked list
     //System.out.println("Now in clear method");
     if (isEmpty() == true)
     {
         System.out.println("The list is already empty");
        }
     else if (head.next == null)
     {
         head = null;
         System.out.println("The only item in the list has been cleared");
        }
     else {
    head = head.next;
     while (head != null)
     {
    head = head.next;
    }
    System.out.println("List Cleared");
    }
    printList();
}
 public void addHead(int data)
 {
     //add item to the head of a singly linked list
    //System.out.println("Now in addHead method");
    if (isEmpty() == true)
     { head = new Node(data);
        }
     else {
     Node newHead = new Node(data);
     Node lastHead = head;
     head = newHead;
     head.next = lastHead;
     while (lastHead.next != null)
     {
     lastHead = lastHead.next;
        }
    }
    printList();
    }
 public boolean isSorted()
 {
     //this will check to see if the singly linked list is sorted
     //System.out.println("Now in isSorted method");
     boolean sorted = false;
         if (isEmpty() == true)
     { System.out.println("The list is empty");
        }
     else if (head.next == null)
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
        sorted = true;
        }
        else {
        sorted = false;
        }
        current = current.next;
        theNext = current.next;
    } while (theNext != null && sorted == true);
    }
    System.out.println("list sorted: " + sorted);
    return sorted;
}

 public boolean isDup(int data, Node checkDups) //Helper method for the addHead method right above. Checks for duplicates in the list
 {
     //  System.out.println("in helper method isDup");
   System.out.println(data);
   
   boolean isDup = false;
  
  do {
    if (checkDups.data == data) {
         isDup = true;
         return isDup;
    }
    else {
        checkDups = checkDups.next;
    }
  }  while (checkDups != null);

  return isDup;
}

public void removeDups()
{
  boolean isSorted = isSorted();
  boolean isDup = false;
  int data = 0;
  if (isSorted == true)
  {
   Node checkDups = new Node();
   Node current = head;
   checkDups = head;
   
   while (checkDups != null)
   {
    data = checkDups.data;
    isDup = isDup(data, checkDups);
    System.out.println("isDup: " + isDup);
    if (isDup == true)
    {
     do
     {
      current = current.next;
        } while (current.next != null);
     current.next = checkDups.next;
    }
    checkDups = checkDups.next;
    }
    }
}


//-------------------------------------------------------------------------TEST DRIVER---------------------------------------------------------------------------------------
 public static void main (String[] args) //Driver
 {
     SingleL a = new SingleL();
     a.addEnd(15);
     a.addEnd(20);
     a.addEnd(30);
     //a.addHead(100);
     //a.addHead(01);
     //a.addHead(02);
     a.isSorted();
     a.checkSize();
     a.clear();
     //a.addEnd(40);
        
    }

}
