import java.util.Scanner;
import java.io.*;
import java.util.*;
public class StackSolve {
	public static void main(String[] args) {
		StackSolve test = new StackSolve();
		test.PostfixArray();
	}
    public void PostfixArray() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        Scanner console = new Scanner(System.in);
        String n;
        int operand1, operand2, result = 0;
        while(true)
        {
            System.out.print("Input expression or (done) to exit: ");
            while(true)
            {
                n = console.next();
                if (n.equals("0"))
                    stack.push(0);
                else if (n.equals("1"))
                    stack.push(1);
                else if (n.equals("2"))
                    stack.push(2);
                else if (n.equals("3"))
                    stack.push(3);
                else if (n.equals("4"))
                    stack.push(4);
                else if (n.equals("5"))
                    stack.push(5);
                else if (n.equals("6"))
                    stack.push(6);
                else if (n.equals("7"))
                    stack.push(7);
                else if (n.equals("8"))
                    stack.push(8);
                else if (n.equals("9"))
                    stack.push(9);
                else if (n.equals("+"))
                {
                    operand1 = stack.top();
                    stack.pop();
                    operand2 = stack.top();
                    stack.pop();
                    result = operand2 + operand1;
                    stack.push(result);
                }
                else if (n.equals("-"))
                {
                    operand1 = stack.top();
                    stack.pop();
                    operand2 = stack.top();
                    stack.pop();
                    result = operand2 - operand1;
                    stack.push(result);
                }
                else if (n.equals("*"))
                {
                    operand1 = stack.top();
                    stack.pop();
                    operand2 = stack.top();
                    stack.pop();
                    result = operand2 * operand1;
                    stack.push(result);
                }
                else if (n.equals("/"))
                {
                    operand1 = stack.top();
                    stack.pop();
                    operand2 = stack.top();
                    stack.pop();
                    result = operand2 / operand1;
                    stack.push(result);
                }
                else if (n.equals("%"))
                {
                    operand1 = stack.top();
                    stack.pop();
                    operand2 = stack.top();
                    stack.pop();
                    result = operand2 % operand1;
                    stack.push(result);
                }
                else if (n.equals("="))
                {
                    System.out.println("result =  " + result);
                    while(!stack.isEmpty())
                        stack.pop();
                    break;
                }
                else if (n.equals("done"))
                {
                    System.out.println("Exit code");
                    System.exit(0);
                }
            }
        }
    }
	//Array based implementation of a Stack ADT
	class ArrayStack<E> {
	   public static int CAPACITY=10;
	   private  E[] data; // holds the stack elements 
	   private int top = -1; // index to top element
	   public ArrayStack() {this(CAPACITY);}
       //@suppressWarning("unchecked") // default constructor
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
	   public void pop() {
	      if (isEmpty()) System.out.println("Stack is empty");
	      else top--;
	   }
	   public E top() {
	      if(isEmpty())  return null;
	      return data[top];
	   }
	   public String toString() {
	      String s="stack: ";
	      for(int i=top; i>=0; i--) 
	         s+=data[i]+" ";
	      return s;
	   }
	   public void push(E e)  {
	      if(size()==data.length) System.out.printf("Stack is full with %d items\n", size());
	      else data[++top]=e;
	   }
	  
	   public  void reverse() {
	      ArrayStack <E>r1 = new ArrayStack<E>(10);
	      ArrayStack <E>r2 = new ArrayStack<E>(10);
	      while(!isEmpty()) {
	         E e =  top();
	         r1.push(e);
	         pop();
	      }
	      while(!r1.isEmpty()) {
	         E e = r1.top();
	         r2.push(e);
	         r1.pop();
	      }
	     while(!r2.isEmpty()) {
	        E e = r2.top();
	        push(e);
	        r2.pop();
	      }
	   }
	   public boolean eliminate (E e) {
	      ArrayStack <E> a = new ArrayStack<E>(10);
	      boolean found = false;
	      while(!isEmpty()) {
	         E c = top();
	         pop();
	         if( c != e) 
	            a.push(c);
	         else found=true;
	      }
	      while(!a.isEmpty()) {
	         E c = a.top();
	         a.pop();
	         push(c);
	      }
	      return found;
	   }
	}

}