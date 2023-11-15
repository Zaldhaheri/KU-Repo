import java.util.*;

public class LinkedQueue<E>  {
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
	private Node<E> front = null;
	private Node<E> tail  = null; //can be omitted
	private int size=0;
	public LinkedQueue(){} //no size here
	public int size() { return size;}
	public boolean isEmpty(){return size==0;} //or return front==null
	public E dequeue(){
    	if(isEmpty()) return null;
    	E temp=front.element;
    	front=front.next;
    	size--;
    	return temp;
	}
	public E peek() {
    	if(isEmpty()) return null;
    	E temp=front.element;
    	return temp;
	}
	public void enqueue(E e) {
    	Node<E> newest = new Node<>(e, null);
    	if(isEmpty()) front=newest;
    	else tail.next=newest; //can be omitted if tail above is omitted
    	tail=newest;
    	size++;
	}
	public String toString() { 
    	Node<E> loc=front;
    	String s="";
    	while(loc!=null) {
        	s+=loc.element+ " ";
        	loc=loc.next;
    	}
    	if(isEmpty()) return "Queue is Empty";
    	return s;
	}
	public  void reverse() {
    	//implement this method based on notes
		Node<E> curr = front;
		LinkedStack<E> stack = new LinkedStack<>();
		while (curr != null)
		{
			stack.push(curr.element);
			curr = curr.next;
		}
		curr = front;
		while(!stack.isEmpty())
		{
			curr.element = stack.top();
			stack.pop();
			curr = curr.next;
		}
	}

	public boolean eliminate (E e) {
    	//implement this method based on notes
		Node<E> prev = null;
		Node<E> curr = front;
		Node<E> temp;
		boolean found = false;
		while(curr != null)
		{
			if (curr.element == e)
			{
				found = true;
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		if (prev == null && curr.element == e)
		{
			temp = curr;
			front = curr.next;
			size--;
		}
		else if(found)
		{
			prev.next = curr.next;
			size--;
		}
		return found;
	}

	public static void main(String args[]) {
    	//implement this method and use similar one for Linked implementation
		LinkedQueue<Integer> q = new LinkedQueue<>();
		int arr[] = {6, 3, 7, 18, 22, 22, 12, 13, 1, 2, 4};
		for (int item : arr)
		{
			q.enqueue(item);
			System.out.println("Queueing " + item + ": " + q);
		}
		int e = q.dequeue();
		System.out.println("Dequeueing item " + e + ": " + q);
		if (q.eliminate(12))
			System.out.println("eliminated 12 is found in queue");
		else
			System.out.println("12 is not found in queue");
		if (q.eliminate(14))
			System.out.println("eliminated 14 is found in queue");
		else
			System.out.println("14 is not found in queue");
		System.out.println("The next item in the queue is " + q.peek());
		q.reverse();
		System.out.println("Reversed " + q);
		while (!q.isEmpty())
		{
			e = q.dequeue();
			System.out.println("Dequeueing " + e + ": " + q);
		}
	}
}   


class LinkedStack<E> {
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
	private Node<E> top= null;
	private int size=0;
	public LinkedStack(){}
	public int size() { return size;}
	public boolean isEmpty(){return size==0;} //or return top==null
	public E top(){
	    if(isEmpty()) return null;
	    return top.getElement();
	}
	public void push(E e) {
	    top=new Node<>(e,top); 
	    size++;
	}
	public void pop() { //change this method to prevent it pop anything if empty
	    if(isEmpty()) {
	        System.out.println("Stack is Empty");
	        return;
	    }
	    top=top.getNext();
        size--;
	}
	   
	public String toString() { 
	    Node<E> loc=top;
        String s="Stack has " + size() + " items: ";
        while(loc!=null) {
            s+=loc.element+ " ";
            loc=loc.next;
        }
        return s;
    }

	   
      //not part of the stack class will be used in lab
    public static boolean isMatched(String expression) {  
        final String opening = "({["; // opening delimiters
        final String closing = ")}]"; // respective closing delimiters
        LinkedStack<Character> buffer = new LinkedStack<Character>( );
        System.out.print("Checking : ");
        for (char c : expression.toCharArray( )) {  
            System.out.printf("%s ", c);
            if (opening.indexOf(c) != -1) // this is a left delimiter
                buffer.push(c);
            else if (closing.indexOf(c) != -1) { // this is a right delimiter
                if (buffer.isEmpty( )) { // nothing to match with
                    System.out.println();
                    return false;
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.top( ))){
                    System.out.println();    
                    return false; // mismatched delimiter
                }
                buffer.pop();
            }
        }
        return buffer.isEmpty( ); // were all opening delimiters matched?
    }

	public void reverse() {  
	    LinkedStack<E> temp1 = new LinkedStack<E>();
	    LinkedStack<E> temp2 = new LinkedStack<E>();
		   
		while (!isEmpty()) {
		    temp1.push(top());
		    pop();
		        
		}
	    while (!temp1.isEmpty()) {
	        temp2.push(temp1.top());
	        temp1.pop();
	    }

	    while (!temp2.isEmpty()) {
		    push(temp2.top());
		    temp2.pop();
	    }
	}
	     
	public boolean eliminate (E e) {
	    LinkedStack<E> temp = new LinkedStack<E>(); 
	    E val;
	    boolean flag = false;
	    while (!isEmpty()) {
		    val=top();
		    if (val!= e) {
			    temp.push(top());
			    pop();
	        } else if(val== e) {
	    	    flag = true;
	    	    pop();
	        }
	    }  
	    while (!temp.isEmpty()) {
			   push(temp.top());
			   temp.pop();
		}
        return flag;
    }
}