import java.io.*;
import java.util.*;
import java.lang.*;
public class GenerateRandom { // generates random numbers and sorted numbers files
    public static void main(String[] args) throws FileNotFoundException {
      	int id = 22; //change your id
        int N = 5000;
      	int random [] = new int[N];
      	PrintWriter randomR = new PrintWriter("random.txt"); // random file
      	PrintWriter sortedR = new PrintWriter("sorted.txt"); // sorted file
        Sorting quickSortR = new Sorting(N);
        Sorting quickSortS = new Sorting(N);
        Sorting quickSortModR = new Sorting(N);
        Sorting quickSortModS = new Sorting(N);
        Sorting heapSortR = new Sorting(N);
        Sorting heapSortS = new Sorting(N);
      	int i = 0;
      	while(i < N) { // loop generates unique random numbers
         	int randomint = (int) (Math.random()*(N)) + id;
         	if ( i == 0 )
            	random[i++] = randomint;
         	else {
            	boolean b = false;
            	for (int j =0; j <i ; j++) {
               		if ( randomint == random[j]) { // ignore if it is found in stored array 
                  		b = true;
                  		break;
               		}
            	}
            	if(!b) // if not stored previously
               		random[i++] = randomint; // add it to the list
         	}
      	}
      	for ( int k = 0 ; k < N ; k++) {
			if (k!=0 && k%10 == 0) {// new line each 10 numbers
            	randomR.println();
            	//System.out.println();
         	}
         	randomR.printf("%6d", random[k]); //write them in the file
         	//System.out.printf("%6d", random[k]); //show them on screen
      	}
      	randomR.close(); //close the random file

		int count=0; // to use for printing a new line every 10 numbers
      	for( int r = id ; r <(N+id) ; r++) { // loop to generate sorted numbers
			if (count!=0 && count++%10 == 0)
            	sortedR.println();
			count++;
         	sortedR.printf("%6d", r); // write them in the file
        }
      	sortedR.close();
        quickSortR.readFile("random.txt");
        quickSortS.readFile("sorted.txt");
        quickSortModR.readFile("random.txt");
        quickSortModS.readFile("sorted.txt");
        heapSortR.readFile("random.txt");
        heapSortS.readFile("sorted.txt");
        long t1,t2, time;

        //quick sort random
        t1 = System.nanoTime();
        quickSortR.quickSort(quickSortR.getData(), 0, N-1);
        t2 = System.nanoTime();
        time = (t2-t1)/1000;
        quickSortR.writeFile("quickSortR.txt", "Quick sort from Random: ");
        System.out.println("Quick sort Random: Comparisons = " + quickSortR.getComparisons() + " Swaps = " + quickSortR.getSwaps());
        System.out.println("Quick sort Random Time: " + time + " ms");

        //quick sort sorted
        t1 = System.nanoTime();
        quickSortS.quickSort(quickSortS.getData(), 0, N-1);
        t2 = System.nanoTime();
        time = (t2-t1)/1000;
        quickSortS.writeFile("quickSortS.txt", "Quick sort from Sorted: ");
        System.out.println("Quick sort Sorted: Comparisons = " + quickSortS.getComparisons() + " Swaps = " + quickSortS.getSwaps());
        System.out.println("Quick sort Sorted Time: " + time + " ms");

        //quick sort modified random
        t1 = System.nanoTime();
        quickSortModR.quickModifiedSort(quickSortModR.getData(), 0, N-1);
        t2 = System.nanoTime();
        time = (t2-t1)/1000;
        quickSortModR.writeFile("quickSortModR.txt", "Quick modified sort from Random: ");
        System.out.println("Quick modified sort Random: Comparisons = " + quickSortModR.getComparisons() + " Swaps = " + quickSortModR.getSwaps());
        System.out.println("Quick modified sort Random Time: " + time + " ms");

        //quick sort modified sorted
        t1 = System.nanoTime();
        quickSortModS.quickModifiedSort(quickSortModS.getData(), 0, N-1);
        t2 = System.nanoTime();
        time = (t2-t1)/1000;
        quickSortModS.writeFile("quickSortModS.txt", "Quick modified sort from Sorted: ");
        System.out.println("Quick modified sort Sorted: Comparisons = " + quickSortModS.getComparisons() + " Swaps = " + quickSortModS.getSwaps());
        System.out.println("Quick modified sort Sorted Time: " + time + " ms");

        //heap sort random
        t1 = System.nanoTime();
        heapSortR.heapSort(heapSortR.getData(), N);
        t2 = System.nanoTime();
        time = (t2-t1)/1000;
        heapSortR.writeFile("heapSortR.txt", "Heap sort from Random: ");
        System.out.println("Heap sort Random: Comparisons = " + heapSortR.getComparisons() + " Swaps = " + heapSortR.getSwaps());
        System.out.println("Heap sort Random Time: " + time + " ms");

        //heap sort sorted
        t1 = System.nanoTime();
        heapSortS.heapSort(heapSortS.getData(), N);
        t2 = System.nanoTime();
        time = (t2-t1)/1000;
        heapSortS.writeFile("heapSortS.txt", "Heap sort from Sorted: ");
        System.out.println("Heap sort Sorted: Comparisons = " + heapSortS.getComparisons() + " Swaps = " + heapSortS.getSwaps());
        System.out.println("Heap sort Sorted Time: " + time + " ms");
    }
    //end of GenerateRandom class 
}

public class Sorting {
    // Method to read input file 
	private int data[];
	private int swaps = 0;
	private int comparisons = 0;
	public Sorting(int capacity){data = new int[capacity];}
	public int getSwaps() {return swaps;}
	public int getComparisons() {return comparisons;}
    public int[] getData() {return data;}

	public void readFile(String filename) throws FileNotFoundException {
    	Scanner s = new Scanner(new File(filename));  
    	int i=0; 
    	while(s.hasNextInt()) 
        	data[i++]=s.nextInt(); // data must be the array name in the class
    	s.close();
	} // end of readFile method

// Method to write output file 
	public void writeFile(String filename, String message) throws FileNotFoundException{
    	PrintWriter fout = new PrintWriter(filename);
    	fout.println(message); // to print the first line in the output file
    	for(int i=0; i<data.length; i++) {
        	fout.printf("%6d", data[i]); // %6d will occupy 6 characters for each number
        	if((i+1)%10==0) fout.println(); //to print a new line after 10 numbers
    	}
    	fout.close();
	} // end of writeFile method

// Swap method to use in both sorting algorithms to have a fair comparison
	public void swap(int data[], int x, int y) { //data must be the name of array in class
    	int temp = data[x]; // x and y are the indices to to swap in the array
    	data[x] = data[y];
    	data[y]= temp;
	} //end of swap method

    public void selectionSort() {
	// Declare and initialize the variables names for swaps and comparisons here
   	// Reduce the size of array A by 1 every iteration (ignore comparison in loop condition)
		swaps = 0;
		comparisons = 0;
    	for(int Last= data.length-1; Last>= 1; Last--){ // find largest item in A[0..Last]
	    	int index_of_largest = 0;
	    	for(int index=1; index <= Last; index++) {
				comparisons++;
     	    	if ((Integer)data[index] > (Integer)data[index_of_largest])
     		    	index_of_largest = index;
        	}
			// swap largest item with last element
			swaps++;
        	swap(data, index_of_largest, Last); //old code of swap replaced by function call
    	}
		// add a line to print the total number of comparisons and swaps here
	}
    public void shortBubbleSort()  { 
	// Declare and initialize the variables names for swaps and comparisons here
		swaps = 0;
		comparisons = 0;
    	boolean sorted = false; //when an iteration has no swaps we stop sorting
    	int n = data.length; // data must be a class variable array
    	// Reduce the size of array A by 1 every iteration ignore comparisons in loop condition
    	for(int Last= n -1; (Last >= 1) && (!sorted) ;  Last--) { 
  	    	sorted=true; // assume array A is sorted
	    	for(int index=0; index < Last; index++) { 
				comparisons++;
       			if (data[index] > data[index + 1])  {
					swaps++;
		      		swap(data, index, index+1);
					//add a line to increment the numbr of swaps here
			    	sorted = false; 
	        	}
         	}
      	}
      // add a line to print the total number of comparisons and swaps here
   }

    // You need all these highlighted in blue and the Random class from YOUR previous lab 
    //constructor, swap, readFile and writeFile
    //You need to declare class variables for counting swaps and comparisons for each //algorithm and its modified version.
    public void quickSort(int A[] , int F, int L) { //note that L is an index =A.length-1
	    int lastS1, pivot;
        comparisons++;
	    if (F<L) {
		    pivot=A[F];
		    lastS1=F;
		    for( int FU=F+1; FU<=L; FU++){
                comparisons++;
			    if (A[FU] < pivot) {
				    lastS1++;
                    swaps++;
				    swap(A, FU, lastS1);
			    }
		    }
            swaps++;
		    swap(A,F, lastS1);
		    quickSort(A, F, lastS1-1);
		    quickSort(A, lastS1+1, L);
 	    }      
    }

    public void quickModifiedSort(int A[] , int F, int L) {
	    int lastS1, pivot;
        comparisons++;
	    if (F<L) {
		    pivot=A[F];
		    lastS1=F;
		    for( int FU=F+1; FU<=L; FU++){
                comparisons++;
			    if (A[FU] < pivot) {
				    lastS1++;
                    comparisons++;
                    if (FU != lastS1){
                        swaps++;
                        swap(A, FU, lastS1);
                    }
			    }
		    }
            comparisons++;
            if (F != lastS1) {
                swaps++;
                swap(A, F, lastS1);
            }
            comparisons++;
            if (F < lastS1 - 1) {
                quickModifiedSort(A, F, lastS1 - 1);
            }
            comparisons++;
            if (lastS1 + 1 < L) {
                quickModifiedSort(A, lastS1 + 1, L);
            }
 	    }      
    }

    public void reheapDown(int values[], int  root, int  bottom) {
		// Pre: root is the index of a node that may violate the heap order property
		// Post: Heap order property is restored between root and bottom
        int  maxChild, rightChild, leftChild;
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        comparisons++;
	    if (leftChild <= bottom) { // ReheapDown continued
            comparisons++;
            if  (leftChild == bottom) {
      	   	    maxChild = leftChild;
	  		} else { 
                comparisons++;
	  		    if (values[leftChild] <= values [rightChild]) {
	  		        maxChild = rightChild;
	  		    } else {
	  			    maxChild = leftChild;
			    }
      	    }
            comparisons++;
     	    if (values[root] < values[maxChild]) { 
                swaps++;
  			    swap (values, root, maxChild);
       	        reheapDown (values, maxChild, bottom);
      		}
   		}
    }

    public void  heapSort (int values[], int numValues) {
   	    //  Post: Sorts array values[ 0 . . numValues-1 ] into ascending order by key
	    int  index ; //loop conditions are not counted
	    // Convert array  values[0..numValues-1] into a heap
	    for  (index = numValues/2 - 1; index>=0; index--) //assuming array is not heap
      	    reheapDown ( values , index , numValues - 1) ;
	    for (index = numValues - 1;  index >= 1;  index--){
            swaps++;
	   	    swap (values, 0 , index);
      	    reheapDown (values , 0 , index - 1);
	    }
    }
}