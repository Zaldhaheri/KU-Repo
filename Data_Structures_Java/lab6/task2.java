
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

    public static void main(String args[])
    {
        LinkedStack<Integer> stack1 = new LinkedStack<>();
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