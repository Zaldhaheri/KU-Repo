import java.util.*;
import java.io.*;

public class main
{
	public static void main(String args[])
	{
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> listm = new SinglyLinkedList<Integer>();
		//UnsortedList<Integer> list2 = new UnsortedList<Integer>();
		//UnsortedList<Integer> listm = new UnsortedList<Integer>();
		list2.addItem(1);
		list2.addItem(0);
		list2.addItem(32);
		list2.addItem(2);
		list2.addItem(10);
		list2.addItem(8);
		list2.addItem(22);
		System.out.println(list2);
		list2.deleteItem(32);
		System.out.println(list2);
		listm.addItem(5);
		listm.addItem(6);
		listm.addItem(7);
		listm.addItem(9);
		listm.addItem(11);
		list2.mergeList(listm);
		System.out.println(list2);
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
		return(size >= MAX);
	}
	public boolean isEmpty()
	{
		return(size == 0);
	}
	public boolean addItem(E item) //Question 2 Array
	{
		if (!itemExists(item) && !isFull())
			info[size++] = item;
		return itemExists(item);
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
	public boolean deleteItem(E item)//Question 3 Array
	{
		boolean NotInList = false;
		int i;
		for(i = 0; i<size; i++)
		{
			if (item == info[i])
			{
				NotInList = true;
				break;
			}
		}
		if (NotInList)
		{
			info[i] = info[size - 1];
			size--;
		}
		return NotInList;
	}

	public boolean valueInList(UnsortedList list, E item) //Question 1 Array
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.info[i] == item)
				return true;
		}
		return false;
	}

	public boolean itemExists(E item) //part of Question 2
	{
		for (int i = 0; i < size; i++)
		{
			if (item == info[i])
				return true;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public void mergeList(UnsortedList list)
	{
		for (int i = 0; i < list.size; i++)
		{
			if (size < MAX)
			{
				info[size++] = (E) list.info[i];
			}
			else
			{
				return;
			}
		}
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
	public boolean addItem(E e)
	{
		boolean itemExists = false;
		Node<E> curr = head;
		while(curr != null)
		{
			if (curr.element == e)
			{
				itemExists = true;
				break;
			}
			curr = curr.next;
		}
		if(!itemExists)
		{
			head = new Node<E>(e, head);
			if (isEmpty())
				tail = head;
			size++;
		}
		return itemExists;
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
	public boolean deleteItem(E e)
	{
		boolean NotInList = false;
		Node<E> curr = head;
		Node<E> prev = null;
		while (curr != null)
		{
			if (curr.element == e)
			{
				NotInList = true;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		if (NotInList)
		{
			size--;
			if (isEmpty())
			{
				head = null;
				tail = null;
			}
			prev.next = curr.next;
			if (curr.next == null)
				tail = prev;
		}
		return NotInList;
	}
	@SuppressWarnings("unchecked")
	public boolean valueInList(SinglyLinkedList list, E item) //Question 1 Linked List
	{
		Node<E> curr = list.head;
		while(curr != null)
		{
			if (curr.element == item)
				return true;
			curr = curr.next;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public void mergeList(SinglyLinkedList list)
	{
		Node<E> listcurr = list.head;
		while(listcurr != null)
		{
			addItemFirst(listcurr.element);
			listcurr = listcurr.next;
		}
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