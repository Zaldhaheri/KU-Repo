import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        ArrayStack<Integer> list = new ArrayStack<Integer>(10);
        list.push(10);
        list.print();
        list.push(2);
        list.print();
        list.push(24);
        list.print();
        list.push(12);
        list.print();
        list.push(55);
        list.print();
        list.push(4);
        list.print();
        list.pop();
        list.print();
        list.pop();
        list.print();
    }
}

public class ArrayStack<E>
{
    private E data[];
    private int top = -1;
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity)
    {
        data = (E[]) new Object[capacity];
    }
    public boolean isEmpty()
    {
        return top == -1;
    }
    public boolean isFull()
    {
        return size() == data.length;
    }
    public int size()
    {
        return top+1;
    }
    public E pop()
    {
        if (isEmpty())
            return null;
        top--;
        return data[top + 1];
    }
    public E top()
    {
        if (isEmpty())
            return null;
        return data[top];
    }
    public void push(E e) throws IllegalStateException
    {
        if (isFull()) throw new IllegalStateException("Stack is full");
        top++;
        data[top] = e;
    }
    public String toString()
    {
        String s = "Stack has " + size() + " items: ";
        for (int i = 0; i < top + 1; i++)
        {
            s += data[i] + " ";
        }
        return s;
    }
    public void print()
    {
        System.out.println(this);
    }
}

public class LinkedStack<E>
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
        public void setNext() {next = n;}
    }
    private Node<E> top = null;
    private int size = 0;
    public LinkedStack() {}
    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E top()
    {
        if (isEmpty())
            return null;
        return top.getElement();
    }
    public void push(E e)
    {
        top = new Node<E>(e, top);
        size++;
    }
    public void pop()
    {
        if (isEmpty())
            return;
        top = top.next;
        size--;
    }
}