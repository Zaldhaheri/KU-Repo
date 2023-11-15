public class Main
{
    public static void main(String args[])
    {
        SortedLinkedList<Integer> list1 = new SortedLinkedList<Integer>();
        list1.add(10);
        list1.add(30);
        list1.add(20);
        list1.add(2);
        System.out.println(list1);
        //System.out.println(list1.addItem(10));
        System.out.println(list1);
        System.out.println(list1.delete(12));
        System.out.println(list1);
    }
}

public class SortedLinkedList<E>
{
    private static class Node<E>
    {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n)
        {
            element = e;
            next = n;
        }
        public E getElement() {return element;}
        public Node<E> getNext() {return next;}
        public void setElement(E e) {element = e;}
        public void setNext(Node<E> n) {next = n;}
    }
    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;
    public SortedLinkedList() {}
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
    public void addItem(E item)
    {
        Node<E> curr = head;
        Node<E> prev = null;
        Node<E> newNode = new Node<E>(item, null);
        if (!isEmpty())
        {
            while (curr != null)
            {
                if ((Integer) item > (Integer) curr.element)
                {
                    prev = curr;
                    curr = curr.next;
                }
                else
                    break;
            }
        }
        if (prev == null)
        {
            head = newNode;
            newNode.next = curr;
        }
        else
        {
            prev.next = newNode;
            newNode.next = curr;
        }
        size++;
    }
    public boolean deleteItem(E item)
    {
        Node<E> temp;
        Node<E> curr = head;
        boolean itemFound = false;
        if (item == head.element)
        {
            itemFound = true;
            temp = curr;
            head = head.next;
            size--;
        }
        else
        {
            while (curr.next != null) {
                if (item == curr.next.element) { // Use .equals() to compare objects
                    temp = curr.next;
                    curr.next = curr.next.next;
                    itemFound = true;
                    size--;
                    break; // Exit the loop once the item is found and deleted
                }
            curr = curr.next;
            }
        }
        return itemFound;
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
    public boolean delete(E item)
    {
        Node<E> temp;
        Node<E> curr = head;
        boolean itemFound = false;
        if (item == head.element)
        {
            temp = head;
            head = head.next;
            itemFound = true;
            size--;
        }
        else
        {
            while(curr.next != null)
            {
                if (item == curr.next.element)
                {
                    temp = curr.next;
                    curr.next = curr.next.next;
                    size--;
                    itemFound = true;
                }
                curr = curr.next;
            }
        }
        return itemFound;
    }
    public void add(E item)
    {
        Node<E> newNode = new Node<E> (item, null);
        Node<E> curr = head;
        Node<E> prev = null;
        if (!isEmpty())
        {
            while(curr != null)
            {
                if ((Integer) item > (Integer) curr.element)
                {
                    prev = curr;
                    curr = curr.next;
                }
                else
                    break;
            }
        }
        if (prev == null)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            prev.next = newNode;
            newNode.next = curr;
        }
        size++;
    }
}