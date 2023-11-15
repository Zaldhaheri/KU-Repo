import java.util.*;

public class ArrayQueue<E> {
	public static int CAPACITY=10;
	private  E[] data; // holds the stack elements 
	private int front = 0; // index to front element
	private int size=0;
	public ArrayQueue() {this(CAPACITY);} // default constructor
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {// constructor
		CAPACITY=capacity;
		data = (E[]) new Object[capacity];
	}
	public boolean isEmpty() { return size==0; }
	public int size() { return size; }
	public E dequeue() {
		if (isEmpty()) {
	    	System.out.println("Queue is empty");
	    	return null;
		}
		E answer = data[front];
		data[front]=null;
		front=(front+1)%data.length;
		size--;
		return answer;
	}
	public E peek() { 
		if(isEmpty())  return null;
		return data[front];
	}
	public String toString() 
	{
		//add your implementation here
		int a = front;
		String s = "Queue is " + size + " items: ";
		for (int i = 0; i < size; i++)
		{
			s += data[a] + " ";
			a = (a + 1) % data.length;
		}
		return s;
	}	
	//change enqueue to avoid crashing and print a statement as shown in output
	public void enqueue(E e)  {
		if(size == data.length)
		{
			System.out.println("Queue is full with " + size + " items");
			return;
		}
		data[(front+size)%data.length]=e;
		size++;
	}
	//change this method to give the same output as the sample output
	public void roundRobin(int n) {  
    	int j=0;
		System.out.println("Starting round robin " + n + " times:");
    	while(!isEmpty()&& j<n) {         
        	E e = dequeue();
			System.out.println("Task=" + j + ": Executing task " + e);
        	enqueue(e);
        	j++;
    	}
	}
	public  void reverse() {
    	//implement this method based on notes
		ArrayStack<E> stack = new ArrayStack<>();
		while(!isEmpty())
		{
			E e = dequeue();
			stack.push(e);
		}
		while(!stack.isEmpty())
		{
			E e = stack.top();
			stack.pop();
			enqueue(e);
		}
	}

	public boolean eliminate (E e) {
    	//implement this method based on notes
		boolean found = false;
		int a = front;
		int i;
		for (i = 0; i < size; i++)
		{
			if (e == data[a])
			{
				found = true;
				break;
			}
			a = (a + 1) % data.length;
		}
		if (found)
		{
			for (int index = i - 1; index < size; index++)
			{
				data[a] = data[(a + 1) % data.length];
				a = (a + 1) % data.length;
			}
			size--;
		}
		return found;
	}

	public static void main(String args[]) {
    	//implement this method and use similar one for Linked implementation
		ArrayQueue<Integer> q = new ArrayQueue<>();
		int arr[] = {6, 3, 7, 18, 22, 22, 12, 13, 1, 2, 4};
		for (int item : arr)
		{
			q.enqueue(item);
			System.out.println("Queueing " + item + ": " + q);
		}
		q.roundRobin(20);
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

public class ArrayStack<E> {
   public static int CAPACITY=10;
   // holds the stack elements 
   private  E[] data;
   // index to top element
   private int top = -1;
   public ArrayStack() {this(CAPACITY);} // default constructor
   @SuppressWarnings("unchecked")
   public ArrayStack(int capacity) {// constructor
      CAPACITY=capacity;
      data = (E[]) new Object[capacity];
   }
   public boolean isEmpty() {
      return top==-1;
   }
   public int size() {
      return top+1;
   }
   public void pop() { // change this method to not pop anything if stack is empty
      if (isEmpty()) {
        System.out.println("Stack is empty");
        return;
      }
      top--;
   }
   
   public E top() {
      if(isEmpty())  return null;
      return data[top];
   }
   // implement this method to print the stack – top first – ArrayStack only
   public String toString() {
      //insert code here 
      String s = "";
      s += "Stack has " + size() + " items: ";
      for (int i = top; i >= 0; i--) {
         s += data[i] + " ";
      }
      return s;
   }
   //change this method to print the message in the output if size is exceeded
  // and also to prevent it from pushing anything if stack is full (second line)
   public void push(E e){
      if(size() == data.length){
         System.out.println("Size is full with " + data.length + " items");
         return;
      }
      data[++top]=e; 
   }
       
   //not part of the stack class but used here as an application method 
   public static boolean isMatched(String expression) {  
      final String opening = "({["; // opening delimiters
      final String closing = ")}]"; // respective closing delimiters
      ArrayStack<Character> buffer = new ArrayStack<Character>( );
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

   //implement this method to reverse a stack using only methods of the class
   // This will allow you to use it in both array and linked list. Use 2 extra 
   // stack objects to achieve this as discussed in class

	public void reverse() {  
	    ArrayStack<E> temp1 = new ArrayStack<E>();
	    ArrayStack<E> temp2 = new ArrayStack<E>();
		   
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
   //implement this method to reverse a stack using only methods of the class
   // This will allow you to use it in both array and linked list. Use an extra 
   // stack object to push only items not equal to e as discussed in class  
   
	public boolean eliminate (E e) {
	    ArrayStack<E> temp = new ArrayStack<E>(); 
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