public class Driver {
    public static void main(String[] args) {
        PQType<Integer> PQ = new PQType<Integer>(17);
        int ID = 22;
        int arr[] = {38, 57, 92, 22, 11, 18, ID, 31, 17, 53, 71, 84, 55, 34, 14, 7};

        System.out.println(PQ);
        for (int item : arr)
            PQ.enqueue(item);
        System.out.println("after enqueueing nodes from array, number of nodes in PQ is: " + PQ.size());
        System.out.println("initial PQ is: " + PQ);
        PQ.enqueue(42);
        System.out.println("After enqueueing 42: " + PQ);
        if (PQ.isFull())
            System.out.println("The PQ is full");
        else
            System.out.println("The PQ is not full");
        
        System.out.println("After dequeueing " + PQ.dequeue() + ": " + PQ);
        System.out.println("After dequeueing " + PQ.dequeue() + ": " + PQ);
        System.out.println("After dequeueing " + PQ.dequeue() + ", length = "+ PQ.size() + ": "+ PQ);
        PQ.enqueue(62);
        System.out.println("After enqueuing 62: " + PQ);
        while (!PQ.isEmpty())
            System.out.println("After dequeueing " + PQ.dequeue() + ": " + PQ);
    }
}

public class PQType <E extends Comparable<? super E>> {  
    private int size;
    private HeapType <E> items;
    private int maxItems;
    public PQType(int max){
        maxItems = max;
        items=new HeapType<E>();
        size = 0;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public boolean isFull() {
        return size==maxItems;
    }
    public E dequeue(){
	    E item=null;
        if (size == 0) System.out.println("Priority Queue is Empty");
        else {
            item = items.info[0];
            items.info[0] = items.info[size-1];
            size--;
            items.reheapDown(0, size-1);
        } 
        return item;
    }
    public void enqueue(E newItem){
        if (size == maxItems) System.out.println("Priority Queue is Full");
        else  {
            size++;
            items.info[size-1] = newItem;
            items.reheapUp(0, size-1);
        }
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
    public int size() {
        return size;
    }
// HeapType inner private class
    @SuppressWarnings("unchecked")
    private class HeapType <E extends Comparable<? super E>>{ //inner class 
        private E info[]; // array to be allocated in the constructor
        public HeapType() { //constructor
            info = (E[]) new Comparable[maxItems]; // maxItems is defined in the parent
        }

        public void reheapDown(int  root, int  bottom) {
            int  maxChild, rightChild, leftChild  ;
            leftChild  =  root * 2 + 1 ;
            rightChild  =  root * 2 + 2 ;
            if (leftChild  <=  bottom) {	// ReheapDown continued
                if  (leftChild  ==  bottom) maxChild  = leftChild;
                else {
	                if (info[leftChild].compareTo(info[rightChild])<=0)
	                    maxChild  =  rightChild ;
	                else	maxChild  =  leftChild ;
                }  
                if  (info[ root ].compareTo(info[maxChild])<0) {
	                swap (root, maxChild);
	                reheapDown(maxChild, bottom);
                }
            }
        }

        public void reheapUp( int root, int bottom ){
            int  parent ;
            if  (bottom > root) {
        	    parent = (bottom - 1)/2;
        	    if (info[parent].compareTo(info[bottom]) <0) {
        	        swap (parent, bottom);
        	        reheapUp(root, parent);
	            }
            }
        }
        public void swap(int a, int b) {
            E temp=info[a];
            info[a]=info[b];
            info[b]=temp;
        }
    } //end of HeapType class 
}
