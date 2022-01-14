
/**
 * Program Name: Linked Lists, Driver Class
 * Author: Jonothan Meyer
 * Date Submitted: 2/20/18
 * 
 * Description: This is the driver class for all things link list related. It handles user input and runs methods from the CircleL, SingleL, and DoubleL classes.
 *
 * Input/Output: User input, ints for singly linked list, doubles for doubly linked lists, and Strings for circular list. Screen output.
 * 
 * Assumptions and Limitations: Depending on the class the data entered by the user must be correct (ints for singly, doubles for doubly, and Strings for Circular) otherwise
 * the program will crash. 
 * 
 * References and Sources: Notes from Computer Science II class, MW 2-4pm, MSU Denver, Dr.Gurka.
 *                         TextBook: Algorithms, 4th edition. Author: Robert Sedgewick, Kevin Wayne. Published: 2011
 * 
 */
import java.util.Scanner;
public class Driver
{ 
 int option = 000;
 Scanner input = new Scanner(System.in);
 SingleL a = new SingleL();
 DoubleL d = new DoubleL();
 CircleL c = new CircleL();
 int chooseInList = 0;

 public void chooseOption()
 {
    while (option != 4) {
     System.out.printf("%-50s\n%-25s\n%-25s\n%-25s\n%-25s\n", "Please select which a type of list:","1: Singly Linked, no tail referance, non-circular, Integers ",
    "2: Doubly-linked, tail referance, non-circular, Doubles ",
    "3: Singly-linked, circular, Strings ", "4: Exit program ");
    //option = 0;
    option = input.nextInt();
      {switch (option) {
        case 1: chooseSingleL();
                break;
        case 2: chooseDoubleL();
                break;
        case 3: chooseCircleL();
                break;
        case 4: break;
        default: System.out.println("That is not a valid option");
        } 
    }
    input.reset();
   } //while (option != 4);
 }

  public void chooseSingleL(){
    //paramater variable is chosen by user. The scanner is in the driver class. This chooses which option within this class to execute
    int data = 0;
    a.printList();
    while (chooseInList != 8) {
    System.out.printf("%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n", "Singly linked, no tail, non-circular list options:","1: Build a list",
    "2: Clear the list","3: Check if list is sorted", "4: Insert at head", "5: Insert at tail", "6: Count size of list", "7: Print the List", 
    "8: Go back");
    chooseInList = input.nextInt();

     switch (chooseInList) {
        case 1: System.out.println("How many elements would you like in the list?");
                int size = input.nextInt();
                for (int i=0;i<size;i++)
                {
                System.out.println("Please enter value");
                data = input.nextInt();
                a.addEnd(data);
                }
                break;
        case 2: a.clear();
                break;
        case 3: a.isSorted();
                break;
        case 4: System.out.println("What would you like to add to the begining of the list?");
                data = input.nextInt();
                a.addHead(data);
                break;
        case 5: System.out.println("What would you like to add to the end of the list?");
                data = input.nextInt();
                a.addEnd(data);
                break;
        case 6: a.checkSize();
                break;
        case 7: a.printList();
                break;
        case 8: break;
        default: System.out.println("That is not a valid option, please enter another number");
        
        } 
   }
    
 }

public void chooseDoubleL() 
{
    double data = 0;
    int nodePos = 0;
    d.printList();
    while (chooseInList != 10) {
    System.out.printf("%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n%-5s\n", "Doubly linked, head and tail referance, non-circular list options:","1: Build a list",
    "2: Insert in specific position","3: Add a double to its proper place in an ordered list", "4: Delete head node", "5: Delete tail node", 
    "6: Print in reverse", "7: Find sum and average of list", "8: Print list", "9: Check size of list", "10: Go back");
    chooseInList = input.nextInt();

     switch (chooseInList) {
        case 1: System.out.println("How many elements would you like in the list?");
                int size = input.nextInt();
                for (int i=0;i<size;i++)
                {
                  System.out.println("Please enter value");
                  data = input.nextInt();
                  d.addEnd(data);
                }
                break;
        case 2: System.out.println("At which position would you like this Node inserted?");
                nodePos = input.nextInt();
                System.out.println("What is the value");
                data = input.nextDouble();
                d.insertPos(data, nodePos);
                break;
        case 3: System.out.println("What double number would you like in order in the list?");
                data = input.nextDouble();
                d.insertInOrder(data);
                break;
        case 4: d.deleteHead();
                break;
        case 5: d.deleteTail();
                break;
        case 6: d.printReverse();
                break;
        case 7: d.average();
                break;
        case 8: d.printList();
                break;
        case 9: d.checkSize();
                break;
        case 10:break;
        default: System.out.println("That is not a valid option, please enter another number");
        
        } 
   }      
}

  public void chooseCircleL(){
    //paramater variable is chosen by user. The scanner is in the driver class. This chooses which option within this class to execute
    String data = "nothing";
    int length = 0;
    c.printList();
    while (chooseInList != 7) {
    System.out.printf("%-50s\n%-25s\n%-25s\n%-25s\n%-25s\n%-25s\n%-25s\n%-25s\n", "Singly linked, head referance, circular list options:","1: Build a list",
    "2: Insert at end","3: Print all Strings of size less than user-input length", "4: Insert at head, without duplication", "5: find min value(s) in list",
    "6: Find max value(s) in list", "7: Exit");
    chooseInList = input.nextInt();

     switch (chooseInList) {
        case 1: System.out.println("How many elements would you like in the list?");
                int size = input.nextInt();
                for (int i=0;i<size;i++)
                {
                 System.out.println("Please enter value");
                 data = input.next();
                 c.addEnd(data);
                }
                break;
        case 2: System.out.println("Which string would you like to insert at the end?");
                data = input.next();
                c.addEnd(data);
                break;
        case 3: System.out.println("What is the length value?");
                length = input.nextInt();
                c.shorterThan(length);
                break;
        case 4: System.out.println("What would you like to add to the begining of the list? (won't be entered if it's a duplicate)");
                data = input.next();
                c.addHead(data);
                break;
        case 5: c.Min();
                break;
        case 6: c.Max();
                break;
        case 7: break;
        default: System.out.println("That is not a valid option, please enter another number");
        
        } 
   }
}

//---------------------------------------------------------------------------------MAIN DRIVER---------------------------------------------------------------------------------------
public static void main (String[] args) //Driver
{
 Driver Driver = new Driver();
 Driver.chooseOption();
    
    
}
}

