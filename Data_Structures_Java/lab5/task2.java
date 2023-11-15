import java.util.*;
import java.lang.*;

public class Driver
{
    public static void main(String args[])
    {
        SortedLinkedList<Integer> list1 = new SortedLinkedList<Integer>();
        SortedLinkedList<Integer> list2 = new SortedLinkedList<Integer>();
        list1.addItem(22);
        System.out.println("list " + list1);
        list1.addItem(18);
        System.out.println("list " + list1);
        list1.addItem(9);
        System.out.println("list " + list1);
        list1.addItem(14);
        System.out.println("list " + list1);
        list1.addItem(8);
        System.out.println("list " + list1);
        list1.addItem(5);
        System.out.println("list " + list1);
        list1.addItem(31);
        System.out.println("List after inserting 31 " + list1);
        if (list1.getItem(8))
            System.out.println("\nItem 8 is in the list");
        else
            System.out.println("\nItem 8 is not in the list");
        if (list1.getItem(17))
            System.out.println("\nItem 17 is in the list");
        else
            System.out.println("\nItem 17 is not in the list");
        list2.addItem(33);
        list2.addItem(12);
        list2.addItem(22);
        list2.addItem(6);
        list2.addItem(10);
        System.out.println("list2 after adding 33, 12, 22, 6 and 10 " + list2);
        if (list1.getItem(19))
            System.out.println("\nItem 19 is in the list");
        else
            System.out.println("\nItem 19 is not in the list");
        list1.deleteItem(22);
        System.out.println("list after deleting 22 " + list1);
        list1.mergeLists(list2);
        System.out.println(list1);
        System.out.println("list1 after merging list2 Size is " +list1.size()+" = " + list1);
    }
        
    
}

public class SortedLinkedList<E> {
   private static class Node<E> { //inner class Node
   	private E element;
   	private Node<E> next;
   	public Node(E e, Node<E> n) {
   		element=e;
   		next=n;
   	}
   	public E getElement() { return element;}
   	public Node<E> getNext() { return next;}
   	public void setNext(Node<E> n) { next=n;}
   } //end of inner class Node   
   private Node<E> head = null;
   //private Node<E> tail = null; // we will ignore the tail here
   private int size=0;
   public SortedLinkedList(){} //default constructor
   public int size() { return size;}
   public boolean isEmpty(){return size==0;}
   public void  addItem( E  item )  {
      Node <E> newNode  = new  Node<E>(item,null) ;
      Node <E> prev =null;
      Node <E> loc= head;
      if(head!=null) {
         while ( true)  {
            if( (Integer)item > (Integer)loc.getElement()) {
               prev=loc;
               loc=loc.next;   
               if(loc==null) break;
            } else {
               break;
            }
         }
      }
      // prepare for insertion
      if  ( prev == null ) {     //insert as first
         newNode.next = head;
         head=newNode;
      } else {          //insert in middle
         newNode.next = loc;
         prev.next=newNode;
      }
      size++;
   }
   public void deleteItem ( E  item ) {
      Node <E> temp, loc=head;
      if(item==head.element) {          
         temp= loc;     // If so, delete first node   
         head= head.next;
      } else {       // search for item in rest of list
         while ( item!=loc.next.element)
            loc= loc.next;
         temp= loc.next; // node will be deleted at loc.next
         loc.next= (loc.next).next;
      }
      size--;
   }
   public boolean getItem( E item)  {        
      Node<E> loc=head;
      boolean found=false; 
      System.out.print("Checking items: ");
      while(true) {
        System.out.print(loc.element +" ");
         if(item==loc.element) {
             found=true; break;
         } else if((Integer)item>(Integer)loc.element) {
            loc = loc.next;
            if(loc==null) break; 
         } else   break; // item<loc.element
      }
      System.out.println();
      return found;
   }
   public String toString() { 
      Node<E> loc=head;
      String s="";
      while(loc!=null) {
         s+=loc.element+ " ";
         loc=loc.next;
      }
      return s;
   }
   public void mergeLists(SortedLinkedList<E> sll) {
      //implement this method using the addItem class method
      Node<E> N = sll.head;
	   while (N != null)
	   {
		   addItem(N.getElement());
		   N = N.next;
	   }
   }       
}
