import java.util.*;
import java.lang.*;

public class Driver
{
    public static void main(String args[])
    {
        SortedList<Integer> list1 = new SortedList<Integer>();
        SortedList<Integer> list2 = new SortedList<Integer>();
        list1.addItem(22);
        System.out.println("list " + list1);
        list1.addItem(18);
        System.out.println("list " + list1);
        list1.addItem(9);
        System.out.println("list " + list1);
        list1.addItem(14);
        System.out.println("list " + list1);
        list1.addItem(8);
        System.out.println("list " + list1);
        list1.addItem(5);
        System.out.println("list " + list1);
        list1.addItem(31);
        System.out.println("List after inserting 31 " + list1);
        if (list1.getItem(8))
            System.out.println("\nItem 8 is in the list");
        else
            System.out.println("\nItem 8 is not in the list");
        if (list1.getItem(17))
            System.out.println("\nItem 17 is in the list");
        else
            System.out.println("\nItem 17 is not in the list");
        list2.addItem(33);
        list2.addItem(12);
        list2.addItem(22);
        list2.addItem(6);
        list2.addItem(10);
        System.out.println("list2 after adding 33, 12, 22, 6 and 10 " + list2);
        if (list1.getItemBSA(19))
            System.out.println("\nItem 19 is in the list");
        else
            System.out.println("\nItem 19 is not in the list");
        list1.deleteItem(22);
        System.out.println("list after deleting 22 " + list1);
        list1.mergeLists(list2);
        System.out.println(list1);
        System.out.println("list1 after merging list2 " + list1);
    }
        
    
}

public class SortedList <E> {
    private static int MAX=10;
    private int size;
    private E info[];  
    public int size(){ return  size; }
    public boolean isFull()  { return size == MAX; }
    public boolean isEmpty() { return size == 0;}
    public SortedList(){ this(MAX); }
    @SuppressWarnings("unchecked")
    public SortedList(int capacity)  { 
        MAX=capacity;
        info =  ((E[])new Object[capacity]); 
    }
    public void addItem(E item) {
    // change this code to make sure that the size does not exceeds MAX
    // print a message (check output) in case size of MAX is exceeded
        if (!isFull())
        {
            int i;
            for(i=0; i<size; i++) {
                if((Integer)item>(Integer)info[i]) continue;
                else break;
            }
            for ( int  index = size ;  index  >  i ;  index--)
                info [ index ] = info [ index - 1 ];
            info [ i ] = item;
            size++;
        }
        else
            System.out.println("List is full");
    }
    public boolean getItem (E item) { 
    //Change this method to print visited numbers info[i] and to stop if info[i]>item
        System.out.print("Checking items: ");
        for(int i=0; i<size; i++) {
            System.out.print(info[i] + " ");
            if ((int)info[i] > (int)item) break;
            if(item!=info[i]) continue;
            else {
                return true;
            }
        }
        return false;     
    }
    public boolean getItemBSA ( E  item ) { 
    // Change this method to print visited numbers info[mid]
        int mid;
        int  first  =  0;
        int   last  = size - 1;
        boolean  moreToSearch  =  ( first  <=  last );
        boolean found = false;
        System.out.print("Checking items: ");
        while ( moreToSearch  &&  !found ) {
            mid  =  ( first + last ) / 2 ;
            System.out.print(info[mid] + " ");
            if((Integer)item<(Integer)info[mid]) {
                last = mid - 1;
                moreToSearch = ( first <= last );
            } else if((Integer)item>(Integer)info[mid]) {
                first = mid + 1;
                moreToSearch = ( first <= last );
            } else {
                found = true ;
            }
        }
        return found;
    }
    public  boolean deleteItem ( E  item ) { 
        for(int i=0; i<size; i++) {
            if(item!=info[i]) continue;
            else {
                for ( int  index = i+ 1 ; index  <  size; index++ )
                info [ index - 1 ] = info [ index ];
                size--;
                return true;
            }
        }
        return false;     
    }    
    public String toString() { 
        //implement this method
        String str = "";
        for (int i = 0; i < size; i++)
        {
            str += info[i] + " ";
        }
        return("is " + size + " items: " + str);
    }
    public void mergeLists(SortedList <E> sl){
        //implement this method using class method addItem
        for (int i = 0; i < sl.size; i++)
        {
            addItem(sl.info[i]);
        }
    } 
} //end of class SortedList

