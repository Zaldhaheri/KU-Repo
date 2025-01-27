import java.util.*;
import java.io.*;

public class main
{
   public static void main(String args[])
   {
	  SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
	  list.addItemFirst(10);
	  System.out.println(list);
	  list.addItemFirst(20);
	  System.out.println(list);
	  list.addItemFirst(30);
	  System.out.println(list);
	  System.out.println(list.getItem(10));
	  System.out.println(list.getItem(20));
	  System.out.println(list.getItem(30));
	

   }
}

public class UnsortedList<E>
{
   private static final int MAX = 10;
   private int size;
   private E info[];

   public UnsortedList()
   {
	  this(MAX);
   }
   @SuppressWarnings("unchecked")
   public UnsortedList(int capacity)
   {
	  info = (E[]) new Object[capacity];
   }

   public int size()
   {
	  return size;
   }
   public boolean isFull()
   {
	  return(size == MAX);
   }
   public boolean isEmpty()
   {
	  return(size == 0);
   }
   public void addItem(E item)
   {
	  info[size++] = item;
   }
   public boolean getItem(E item)
   {
	  for (int i = 0; i < size; i++)
	  {
		 if (info[i] == item)
			return true;
	  }
	  return false;
   }
   public boolean deleteItem(E item)
   {
	  for (int i = 0; i < size; i++)
	  {
		 if (info[i] == item)
		 {
			info[i] = info[size - 1];
			size--;
			return true;
		 }
	  }
	  return false;
   }

   public String toString()
   {
	  String s = "List has " + size + " Items: ";
	  for (int i = 0; i < size; i++)
	  {
		 s += info[i] + " ";
	  }
	  return s;
   }
}

public class SinglyLinkedList <E>
{
   private static class Node<E>
   {
	  private E element;
	  private Node<E> next;
	  public Node(E e, Node <E> n)
	  {
		 element = e;
		 next = n;
	  }
	  public E getElement() {return element;}
	  public Node<E> getNext() {return next;}
	  public void setNext(Node<E> n) {next = n;}
   }
   private Node<E> head = null;
   private Node<E> tail = null;
   private int size = 0;
   public SinglyLinkedList() {};
   public int size() {return size;}
   public boolean isEmpty() {return size == 0;}
   public E first()
   {
	  if (isEmpty())
		 return null;
	  return head.getElement();
   }
   public E last()
   {
	  if (isEmpty())
		 return null;
	  return tail.getElement();
   }
      public boolean getItem(E e)
   {
	Node<E> cur = head;
	boolean found = false;
	if (head != null)
	{
		do{
			if (e == cur.getElement())
			{
				found = true;
				break;
			}
			cur = cur.next;
		} while(cur != null);
	}
	return found;
   }
   public void addItemFirst(E e)
   {
	  head = new Node<>(e, head);
	  if (isEmpty())
		 tail = head;
	  size++;
   }
   public void addItemLast(E e)
   {
	  Node<E> newest = new Node<>(e, null);
	  if (isEmpty())
		 head = newest;
	  else
		 tail.setNext(newest);
	  tail = newest;
	  size++;
   }
   public E deleteFirstItem()
   {
	  if (isEmpty())
		 return null;
	  E item = head.getElement();
	  head = head.getNext();
	  size--;
	  if (isEmpty())
		 tail = null;
	  return item;
   }
   public E deleteLastItem()
   {
	  if (isEmpty())
		 return null;
	  E item = tail.getElement();
	  Node<E> prev = null;
	  Node<E> current = head;
	  while(current.next != null)
	  {
		 prev = current;
		 current = current.next;
	  }
	  if (prev == null)
	  {
		 head = null;
		 tail = null;
	  }
	  else
	  {
		 prev.setNext(null);
		 tail = prev;
	  }
	  size--;
	  return item;
   }
   public E deleteItem(E e)
   {
	  if (isEmpty())
		 return null;
	  E item = head.getElement();
	  Node<E> prev = null;
	  Node<E> current = head;
	  boolean found = false;
	  while (current != null)
	  {
		 item = current.getElement();
		 if (e == item)
		 {
			found = true;
			break;
		 }
		 else
			prev = current;
			current = current.next;
	  }
	  if (found)
	  {
		 size--;
		 if (isEmpty())
		 {
			tail = null;
			head = null;
		 }
		 else
		 {
			prev.next = current.next;
			if (current.next == null)
			   tail = prev;
		 }
		 return item;
	  }
	  return null;
   }

   public String toString()
   {
	  String s = "List has " + size + " Items: ";
	  Node<E> prev = null;
	  Node<E> curr = head;
	  for (int i = 0; i < size; i++)
	  {
		 s += curr.getElement() + " ";
		 curr = curr.next;
	  }
	  return s;
   }
}

public class UnsortedArrayList<E>
{
   public static final int MAX = 10;
   private int size;
   private ArrayList<E> info;
   public int size() {return size;}
   public boolean isFull() {return size == MAX;}
   public boolean isEmpty() {return size == 0;}
   public UnsortedArrayList() {this(MAX);}
   public UnsortedArrayList(int capacity)
   {
	  info = new ArrayList<E>(capacity);
   }
   public void addItem(E item)
   {
	  info.add(item);
	  size++;
   }
   public boolean getItem (E item)
   {
	  return info.contains(item);
   }
   public boolean deleteItem (E item)
   {
	  if (info.contains(item))
	  {
		 size--;
		 info.remove(item);
		 return true;
	  }
	  return false;
   }
   public void print()
   {
	  System.out.println(info);
   }

}