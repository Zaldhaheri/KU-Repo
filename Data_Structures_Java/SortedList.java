public class Main
{
    public static void main(String args[])
    {
        SortedLinkedList<Integer> list = new SortedLinkedList<Integer>();
        list.addItem(10);
        list.addItem(12);
        list.addItem(22);
        list.addItem(15);
        System.out.println(list);
        SortedLinkedList<Integer> list2 = list.splitList(13);
        System.out.println(list);
        System.out.println(list2);
    }
}

public class SortedList<E>
{
    private static int MAX = 10;
    private int size;
    private E info[];
    public int size() {return size;}
    public boolean isFull() {return size == MAX;}
    public boolean isEmpty() {return size == 0;}
    public SortedList() {this(MAX);}
    @SuppressWarnings("unchecked")
    public SortedList(int capacity)
    {
        MAX = capacity;
        info = (E[]) new Object[capacity];
    }
    public void addItem(E item)
    {
        int i;
        for (i = 0; i<size; i++)
        {
            if ((Integer) item > (Integer) info[i])
                continue;
            else
                break;
        }
        for (int index = size; index > i; index--)
            info [index] = info[index - 1];
        info[i] = item;
        size++;
    }
    public boolean deleteItem(E item)
    {
        int i;
        boolean found = false;
        for (i = 0; i < size; i++)
        {
            if(item == info[i])
            {
                found = true;
                break;
            }
        }
        if (found)
        {
            for (int index = i; index < size - 1; index++)
                info[index] = info[index + 1];

            size--;
        }
        return found;
    }
    public boolean getItem(E item)
    {
        int i;
        for (i = 0; i < size; i++)
        {
            if (item == info[i])
                return true;
        }
        return false;
    }
    public boolean getItemBSA(E item)
    {
        int mid;
        int first = 0;
        int last = size - 1;
        boolean moreToSearch = first <= last;
        boolean found = false;
        while(moreToSearch && !found)
        {
            mid = (first + last) / 2;
            if ((Integer) item < (Integer) info[mid])
            {
                last = mid - 1;
                moreToSearch = (first <= last);
            }
            else if ((Integer) item > (Integer) info[mid])
            {
                first = mid + 1;
                moreToSearch = (first <= last);
            }
            else
                found = true;
        }
        return found;
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
        public void setNext(Node<E> n) {next = n;}
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SortedLinkedList() {};
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
    public void addItem(E item)
    {
        Node<E> newNode = new Node<E>(item, null);
        Node<E> prev = null;
        Node<E> curr = head;
        if (!isEmpty())
        {
            while(true)
            {
                if((Integer) item > (Integer) curr.element)
                {
                    prev = curr;
                    curr = curr.next;
                    if (curr == null)
                        break;
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
            newNode.next = curr;
            prev.next = newNode;
        }
        size++;
    }
    public void deleteItem(E item)
    {
        Node<E> temp;
        Node<E> curr = head;
        if (item == head.element)
        {
            temp = curr;
            head = head.next;
        }
        else
        {
            while (item != curr.next.element)
                curr = curr.next;
            temp = curr.next;
            curr.next = (curr.next).next;
        }
        size--;
    }
    public boolean findItem(E item)
    {
        Node<E> curr = head;
        boolean found = false;
        while (true)
        {
            if (item == curr.element)
            {
                found = true;
                break;
            }
            else if ((Integer) item > (Integer)curr.element)
            {
                curr = curr.next;
                if (curr == null)
                    break;
            }
            else
                break;
        }
        return found;
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
   public SortedLinkedList<E> splitList(E item)
   {
    Node<E> cur = head;
    Node<E> prev = null;
    SortedLinkedList<E> list = new SortedLinkedList<>();
    while(cur!= null)
    {
        if ((Integer) cur.element < (Integer) item)
        {
            list.addItem(cur.element);
        }
        prev = cur;
        cur = cur.next;
    }
    cur = list.head;
    while (cur != null)
    {
        if ((Integer) cur.element > (Integer) item){
            size--;
            deleteItem(cur.element);
        }
        prev = cur;
        cur = cur.next;
    }
    return list;
   }
}
