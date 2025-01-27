import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        LinkedQueue<Integer> q = new LinkedQueue<Integer>();
        q.enqueue(10);
        System.out.println(q);
        q.enqueue(12);
        System.out.println(q);
        q.enqueue(14);
        System.out.println(q);
        q.enqueue(1);
        System.out.println(q);
        q.enqueue(8);
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);

    }
}

public class ArrayQueue<E>
{
    private static int DEF = 10;
    private E data[];
    private int f = 0;
    private int sz = 0;
    public ArrayQueue() {this(DEF);}
    @SuppressWarnings("unchecked")
    public ArrayQueue(int c) {data = (E[]) new Object[c];}
    public int size() {return sz;}
    public boolean isEmpty() {return sz == 0;}
    public boolean isFull() {return sz == data.length;}
    public void enqueue(E e) throws IllegalStateException
    {
        if (isFull()) throw new IllegalStateException("Queue is full");
        int a = (f + sz) % data.length;
        data[a] = e;
        sz++;
    }
    public E dequeue()
    {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
    public String toString()
    {
        String s = "Queue has " + sz + " items: ";
        int a = f;
        for (int i = 0; i < sz; i++)
        {
            s += data[a] + " ";
            a = (a + 1) % data.length;
        }
        return s;
    }
}

public class LinkedQueue<E>
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
    private Node<E> front = null;
    private Node<E> tail = null;
    private int size = 0;
    public LinkedQueue(){}
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E dequeue()
    {
        if (isEmpty()) return null;
        E temp = front.element;
        front = front.next;
        size--;
        return temp;
    }
    public void enqueue(E e)
    {
        Node<E> newNode = new Node<>(e, null);
        if(isEmpty()) front = newNode;
        else tail.next = newNode;
        tail = newNode;
        size++;
    }
    public E peek()
    {
        if (isEmpty()) return null;
        return front.element;
    }
    // public void reverseQueue()
    // {
    //     LinkedStack<E> s = new LinkedStack<E>();
    //     while(!isEmpty())
    //     {
    //         E e = dequeue();
    //         s.push(e);
    //     }
    //     while(!s.isEmpty())
    //     {
    //         E e = s.top();
    //         enqueue(e);
    //         s.pop();
    //     }
    // }
    public String toString()
    {
        Node<E> curr = front;
        String s = "Queue has " + size + " items: ";
        while(curr != null)
        {
            s += curr.element + " ";
            curr = curr.next;
        }
        return s;
    }
}
