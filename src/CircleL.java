
/**
 * Program name: Linked Lists, Class for the circularly linked list operations 
 * Author: Jonothan Meyer
 * Date: 2/20/18
 * 
 * Description: This class handles everything dealing with circularly linked lists.
 * Input/Output: Input delivered into method parameters in Driver class, screen message output.
 * Assumptions and Limitations: only handles input for Strings
 * References and Sources: See: Driver class
 */
public class CircleL
{
  Node head = null;
  private class Node{
   String data;
   private Node next;
   Node() {
          this.data = data;
      } //default constructor
   Node(String data) {
      this.data = data;
      }
    }// end of class Node
    
 public boolean isEmpty() 
 {
     //check to see that the list is empty
     return head == null;
    }
    
  public void printList()
 { //print the entire list
   //System.out.println("now in printList method");
    if (isEmpty())
    {
     System.out.println("head > null");
    }
    else if (head.next == head)
    {

     System.out.println("head > " + head.data + " > head");   
    }
    else {
    System.out.print("head");
    Node current = head;
    do  {
    System.out.print(" > " + current.data);
    current = current.next;
    } while (current != head);
    System.out.print(" > head");
    System.out.println();
    }
    }
    
 public void addEnd(String data)
 {
     //add item to the end of a singly linked list
     //System.out.println("Now in addEnd method);
    boolean isDup = false;
    if (isEmpty())
    {
    head = new Node(data);
    head.next = head;
    }
    else if (head.next == head) {
    isDup = isDup(data);
     if (isDup == false) {
    Node temp = new Node(data);    
    head.next = temp;
    temp.next = head;
       }
       else {
        System.out.println("String not entered into list to avoid duplication");
       }
    }
    else {
    isDup = isDup(data);
    if (isDup == false) {
    Node temp = new Node(data);
    Node traveler = new Node();
    traveler = head;
    while (traveler.next != head) {
    traveler = traveler.next;  
    }
    traveler.next = temp;
    temp.next = head;
       }
       else {
        System.out.println("data is already in list");   
        }
    }
    printList();
    }
    
 public void shorterThan(int length) 
 { 
  //System.out.println("Now in shorterThan method");


   if (isEmpty())
   {
   System.out.println("The list is empty");  
    }
   else if (head.next == head) {
    String x = head.data;
    int j = x.length();
    if (j <= length) {
    System.out.println("The only word in the list, " + head.data + ", is shorter than " + length + " characters"); 
        } // end if
    } // end elseif
   else {
   String x = head.data;
   int j = x.length();
   Node temp = new Node();
   temp = head;
   System.out.print("Here are the words within the list that were shorter than " + length + " characters: ");
   while (temp.next != head)
   {
    x = temp.data;
    j = x.length();

     if (j <= length) {
      System.out.print(temp.data + " ");
        }
    temp = temp.next;
    }
  }
  System.out.println();
    }
    
 public void Min() 
 {
   if (isEmpty())
   {
   System.out.println("The list is empty");  
    }
   else if (head.next == head) {
   System.out.println("There is only one element in the list, " + head.data + ", it has the min and max length");
    } // end if
   else {
         String x = head.data;
  String y = "nothing";
  int t = x.length();
  int at = 0;
  int min = 0;
   Node temp = new Node();
   Node afterTemp = new Node();
   temp = head;
   afterTemp = temp.next;
   while (afterTemp != head)
   {
    x = temp.data; //holds the string from the node
    t = x.length(); //converts that string into int for checking length
    y = afterTemp.data;
    at = y.length(); //at for afterTemp
    min = Math.min(t, at);
        if (min == t) {
     afterTemp = afterTemp.next;
    }
    else {
    temp = temp.next;
      }
    }
   System.out.println("Shortest String in the list: " + min);
   temp = head;
   System.out.print("Here is/are the shortest String(s) in the list: ");
   do {
     x = temp.data;
     t = x.length();
     if (t == min) 
     {
      System.out.print(x + " ");
        }
     temp = temp.next;
    }  while (temp != head);
    System.out.println();
  }   
    }
    
  public void Max() 
 {
  //System.out.println("Now in Max() method");

   if (isEmpty())
   {
   System.out.println("The list is empty");  
    }
   else if (head.next == head) {
   System.out.println("There is only one element in the list, " + head.data + ", it has the min and max length");
    } // end if
   else {
     String x = head.data;
  String y = "nothing";
  int t = x.length();
  int at = 0;
  int max = 0;
   Node temp = new Node();
   Node afterTemp = new Node();
   temp = head;
   afterTemp = temp.next;
   while (afterTemp != head)
   {
    x = temp.data;
    t = x.length();
    y = afterTemp.data;
    at = y.length();
    max = Math.max(t, at);
    if (max == t) {
     afterTemp = afterTemp.next;
    }
    else {
    temp = temp.next;
      }
    }
   System.out.println("Largest String in the list: " + max);
   temp = head;
   System.out.print("Here is/are the longest String(s) in the list: ");
   do {
    {
     x = temp.data;
     t = x.length();
     if (t == max) 
     {
      System.out.print(x + " ");
        }
     temp = temp.next;
    }
   } while (temp != head);
  }
  System.out.println();
    }
 
 public void addHead(String data) //without duplication
 { //System.out.println("Now in addHead method");
   if (isEmpty()) {
   Node temp = new Node(data);

    }
   else if (head.next == head) {
   Node newHead = new Node(data);
   Node lastHead = head;
   head = newHead;
   newHead.next = lastHead;
   lastHead.next = head;
    }
   else {
   boolean isDup = isDup(data);
   System.out.println("Is there a duplicate: " + isDup);
   if (isDup == false)
   {

    Node newHead = new Node(data);
    Node traveler = head;
    Node oldHead = head;
    while (traveler.next != head)
    {
    traveler = traveler.next;
    }
    traveler.next = newHead;
    newHead.next = head;
    head = newHead;
    }
   else {
       System.out.println("String not added to list to avoid duplication");   
    }
   printList();  
 }
}
 
 public boolean isDup(String data) //Helper method for the addHead method right above. Checks for duplicates in the list
 {
     //  System.out.println("in helper method isDup");
   String checkDup = data;
   Node temp = new Node();
   Node traveler = head;
   boolean isDup = false;
  
  do {
    if (checkDup.equalsIgnoreCase(traveler.data)) {
         isDup = true;
         return isDup;
    }
    else {
        traveler = traveler.next;
    }
  }  while (traveler != head);

  return isDup;
}


//--------------------------------------------------------------------------FOR TESTING ONLY----------------------------------------------------------------------------------------
 public static void main (String[] args) //test driver
 {
   CircleL c = new CircleL();
   c.addEnd("dog");
   c.addEnd("cat");
   c.addEnd("meow");
   c.addEnd("baller");
   c.shorterThan(7);
   c.Min();
   c.Max();
   c.addHead("WayMoreBaller");
    }
    
}


