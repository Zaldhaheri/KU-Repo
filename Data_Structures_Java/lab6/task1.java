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

    public static void main(String args[])
    {
        ArrayStack<Integer> stack1 = new ArrayStack<>();
        stack1.pop();
        int[] items = {6, 3, 7, 9, 22, 22, 12, 13, 1, 2, 4};
        for (int item : items) {
            System.out.print("Pushing " + item + ": ");
            stack1.push(item);
            System.out.println(stack1);
        }
        int top = stack1.top();
        stack1.pop();
        System.out.println("topped and popped item " + top + ": " + stack1);
        if (stack1.eliminate(12))
            System.out.println("12 is found in stack");
        else
            System.out.println("12 is not found in stack");
        if (stack1.eliminate(14))
            System.out.println("14 is found in stack");
        else
            System.out.println("14 is not found in stack");
        String matched = "{ ( ( ) [ ] ) }";
        String unmatched = "{ ( ( ) }";
        boolean isMatched1 = stack1.isMatched(matched);
        if (isMatched1) {
            System.out.println("\n{(()[])} has Matching brackets");
        } else {
            System.out.println("\n{(()[])} has no Matching brackets");
        }

        boolean isMatched2 = stack1.isMatched(unmatched);
        if (isMatched2) {
            System.out.println("{(()[])} has Matching brackets");
        } else {
            System.out.println("{(()[])} has no Matching brackets");
        }

        stack1.reverse();
        System.out.println("Reversed " + stack1);

        int i = 0;
        while(!stack1.isEmpty()) {
            top = stack1.top();
            stack1.pop();
            System.out.println("topped and popped item " + top + ": " + stack1);
            i++;
        }
    }
}
