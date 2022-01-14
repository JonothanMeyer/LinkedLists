/**
 * Write a description of class ExamOne here.
 *
 * @author Jonothan Meyer
 * @version 1.1 1/13/21
 */
public class Stack
{
  Node top;
 
  private class Node 
  {
   private Node next;
   private int data;
   Node()
   {
   this.data = data;   
    } //default constructor
   Node(int data)
   {
   this.data = data;   
    } //overloaded constructor
    }
    
  public boolean isEmpty()
  {
  return top == null;  
    }
  
  public void push(int data)
  {
    Node oldTop = top;
    Node newTop = new Node(data);
    top = newTop;
    top.next = oldTop;
   }


  public void printStack()
  {
  if (isEmpty())
  {
   System.out.println("The Stack is empty:");   
    }
  else if (top.next == null)
  {
   System.out.println("Top > " + top.data + " > Bottom"); 
    }
  else {
   System.out.print("Top");
   Node traveler = new Node();
   traveler = top;
   while (traveler != null)
   {
   System.out.print(" > " + traveler.data);
   traveler = traveler.next;
    }
    }
    
    }
    
    
 public static void main (String[] args)
 {
  Stack x= new Stack();
  x.push(25);
  x.push(28);
  x.push(0);
  x.printStack();
  
  
     
     
    }
}

