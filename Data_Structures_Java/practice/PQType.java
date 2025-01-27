import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        PQType<Integer> pq = new PQType<Integer>(10);
        pq.enqueue(5);
        System.out.println("PQ: " + pq);
        pq.enqueue(7);
        System.out.println("PQ: " + pq);
        pq.enqueue(8);
        System.out.println("PQ: " + pq);
        pq.enqueue(6);
        System.out.println("PQ: " + pq);
        pq.enqueue(10);
        System.out.println("PQ: " + pq);
        System.out.println("Dequeued(" + pq.dequeue() + "): " + pq);
    }
}

public class PQType <E extends Comparable<? super E>> {

    private int size;
    private HeapType<E> items;
    private int maxItems;
    @SuppressWarnings("unchecked")
    public PQType(int max) {
        maxItems = max;
        items = new HeapType();
        size = 0;
    }
    public boolean isEmpty() {return size == 0;}
    public boolean isFull() {return size >= maxItems;}
    public void enqueue(E newItem) {
        if (isFull())
            System.out.println("PQ is full");
        else {
            size++; //increase the length
            items.info[size - 1] = newItem; //add new item to the last position
            items.ReheapUp(0, size - 1); //reheapUp to order the new item
        }
    }
    public E dequeue() {
        E item = null;
        if (isEmpty())
            System.out.println("PQ is empty");
        else {
            item = items.info[0]; //set the root to item
            items.info[0] = items.info[size - 1]; //move last item to the root
            size--; //decrement length
            items.ReheapDown(0, size-1); //reheapDown after the deletion of root
        }
        return item; //return the deleted item
    }
    public String toString()  {    
        String s="";
        if (isEmpty()) 
            return "PQ is empty";
        else
            for (int i=0; i< size; i++) 
                s+=items.info[i]+" ";
        return s;
    }
    private class HeapType <E extends Comparable<? super E>> {
        public void ReheapDown(int root, int bottom) {
            int maxChild, leftChild, rightChild; //setup the indexes
            leftChild = root * 2 + 1; //index of the left child of the root
            rightChild = root * 2 + 2; //index of the right child of the root
            if (leftChild <= bottom) { //checks if the index of the leftChild is less than or equal to index of bottom(last element)
                if (leftChild == bottom) //if the leftChild is the bottom(last element)
                    maxChild = leftChild; //the maxChild is now the leftXhild
                else { //if the left child is not the bottom
                    if (info[leftChild].compareTo(info[rightChild]) <= 0) //if the element of the leftChild is less than/equal to rightChild
                        maxChild = rightChild; //set maxChild to rightChild since its larger
                    else //if leftChild is greater than rightChild
                        maxChild = leftChild; //set maxChild to leftChild since its larger
                }
                if (info[root].compareTo(info[maxChild]) < 0) { //if element of root is less than maxChild
                    swap(root, maxChild); //swap root and child elements
                    ReheapDown(maxChild, bottom); //call reheap where the root is the maxChild index, bottom index is unchanged
                }
            }
        }
        public void ReheapUp(int root, int bottom) {
            int parent; //setup parent index
            if (bottom > root) { //if the bottom index is greater than root index (always true if root != bottom)
                parent = (bottom - 1)/2; //index of the parent of the bottom
                if (info[parent].compareTo(info[bottom]) < 0) { //if element of parent is less than element of bottom
                    swap(parent, bottom); //swap parent and bottom elements
                    ReheapUp(root, parent); //the bottom is now the parent, root is unchanged
                }
            }
        }
        public void swap(int a, int b) {
            E temp = info[a];
            info[a] = info[b];
            info[b] = temp;
        }
        private E info[];
        @SuppressWarnings("unchecked")
        public HeapType() {info = (E[]) new Comparable[maxItems];}
    }

}