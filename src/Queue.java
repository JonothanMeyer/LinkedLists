
/**
 * Basic Queue functionality for integers
 *
 * @author Jonothan Meyer
 * @version 
 */
public class Queue
{
  Node front;
  Node back;
  private class Node
  {
  Node next;
  int data;
  public Node()
  {
  this.data = data;      
    }
  public Node(int data)
  {
  this.data = data;
    }
 }
 
 public void enqueue(int data)
 {
 if (front == null)
 {
 front = back = new Node(data);
 front.next = back;
    }
 else if (front.next == back)
 {
 back = new Node(data);
 front.next = back;
    }
 else {
 Node newback = new Node(data);
 Node oldBack = back;
 newback.next = oldBack;
 back = newback;
    }     
    }
 public Node dequeue()
 { 
   Node current = front;

   front = front.next;
   return current;
    }
 
}

