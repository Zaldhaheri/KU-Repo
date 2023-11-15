import java.io.*;
import java.util.*;
import java.lang.*;
public class GenerateRandom { // generates random numbers and sorted numbers files
    public static void main(String[] args) throws FileNotFoundException {
      	int id = 22; //change your id
      	int random [] = new int[20000];
      	PrintWriter randomR = new PrintWriter("random.txt"); // random file
      	PrintWriter sortedR = new PrintWriter("sorted.txt"); // sorted file
		Sorting selectionR = new Sorting(20000);
		Sorting selectionS = new Sorting(20000);
		Sorting bubbleR = new Sorting(20000);
		Sorting bubbleS = new Sorting(20000);
      	int i = 0;
      	while(i < 20000) { // loop generates unique random numbers
         	int randomint = (int) (Math.random()*(20000)) + id;
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
      	for ( int k = 0 ; k < 20000 ; k++) {
			if (k!=0 && k%10 == 0) {// new line each 10 numbers
            	randomR.println();
            	//System.out.println();
         	}
         	randomR.printf("%6d", random[k]); //write them in the file
         	//System.out.printf("%6d", random[k]); //show them on screen
      	}
      	randomR.close(); //close the random file

		int count=0; // to use for printing a new line every 10 numbers
      	for( int r = id ; r <(20000+id) ; r++) { // loop to generate sorted numbers
			if (count!=0 && count++%10 == 0)
            	sortedR.println();
			count++;
         	sortedR.printf("%6d", r); // write them in the file
        }
      	sortedR.close(); //close the sorted file
		selectionR.readFile("random.txt");
		selectionS.readFile("sorted.txt");
		bubbleR.readFile("random.txt");
		bubbleS.readFile("sorted.txt");
		long t1,t2,time;
		t1 = System.nanoTime();
		selectionR.selectionSort();
		t2 = System.nanoTime();
		time = (t2-t1)/1000;
		System.out.println("Selection Sort for Random: Comparisons = " + selectionR.getComparisons() + ", Swaps = " + selectionR.getSwaps());
		System.out.println("Selection Sort for Random Numbers Time: " + time + " ms");
		selectionR.writeFile("selectionSortedr.txt", "Selection Sort Numbers From Random: ");
		t1 = System.nanoTime();
		selectionS.selectionSort();
		t2 = System.nanoTime();
		time = (t2-t1)/1000;
		System.out.println("Selection Sort for Sorted: Comparisons = " + selectionS.getComparisons() + ", Swaps = " + selectionS.getSwaps());
		System.out.println("Selection Sort for Sorted Numbers Time: " + time + " ms");
		selectionS.writeFile("selectionSorteds.txt", "Selection Sort Numbers From Sorted: ");
		t1 = System.nanoTime();
		bubbleR.shortBubbleSort();
		t2 = System.nanoTime();
		time = (t2-t1)/1000;
		System.out.println("Bubble Sort for Random: Comparisons = " + bubbleR.getComparisons() + ", Swaps = " + bubbleR.getSwaps());
		System.out.println("Bubble Sort for Random Numbers Time: " + time + " ms");
		bubbleR.writeFile("bubbleSortedr.txt", "Bubble Sort Numbers From Random: ");
		t1 = System.nanoTime();
		bubbleS.shortBubbleSort();
		t2 = System.nanoTime();
		time = (t2-t1)/1000;
		System.out.println("Bubble Sort for Sorted: Comparisons = " + bubbleS.getComparisons() + ", Swaps = " + bubbleS.getSwaps());
		System.out.println("Bubble Sort for Sorted Numbers Time: " + time + " ms");
		bubbleS.writeFile("bubbleSorteds.txt", "Bubble Sort Numbers From Sorted: ");
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
}