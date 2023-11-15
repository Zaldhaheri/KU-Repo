
public class Driver
{
    public static void main(String args[])
    {
        UnsortedList<Integer> List = new UnsortedList<>();
        int[] arr = {22, 24, 11, 14, 8, 6};
        for (int i = 0; i < 6; i++)
        {
            List.addItem(arr[i]);
        }
        System.out.print("List has " + List.size() + " items: ");
        System.out.println(List);

        List.addItem(30);
        System.out.println("List after adding 30 has " + List.size() + " items: " + List);

        if (List.getItem(8))
            System.out.println("Item 8 is in the list");
        else
            System.out.println("Item 8 is not in the list");
        
        if (List.getItem(19))
            System.out.println("Item 19 is in the list");
        else
            System.out.println("Item 19 is not in the list");
        
        List.addItem(31);
        List.addItem(33);
        List.addItem(34);
        List.addItem(36);
        System.out.println("List after adding 31, 33, 34, and 36 has " + List.size() + " items: " + List);

        List.deleteItem(22);
        System.out.println("List after deleting 22 has " + List.size() + " items: " + List);           
    }
}

public class UnsortedList<E> {
    private static final int MAX=10;
    private int size;
    private E info[];  
    public int size(){ return  size; }
    public boolean isFull()  { return size == MAX; }
    public boolean isEmpty() { return size == 0;}
    @SuppressWarnings("unchecked")
    public UnsortedList(){ this(MAX); }
    @SuppressWarnings("unchecked")
    public UnsortedList(int capacity)  { 
        info = (E[]) new Object[capacity];
    }
    public void addItem(E item) {
    // change this code to ensure that the list does not exceeds the maximum size// done
        if (size < MAX)
            info[size++] = item;
    }  
    public boolean getItem (E item) { 
        for(int i=0; i<size; i++) {
            if(item!=info[i]) continue;
            else return true;
        }
        return false;     
    }
    public  boolean deleteItem ( E  item ) {
    // change this code to make sure that if the item is not in the list the method
    // returns false 
        for(int i=0; i<size; i++) {
            if(item==info[i]) {
                info[i]=info[size-1];
                size--;
                return true;
            }
        }
        return false;
    }
    public String toString(){
        // implement this method to return a string of all the elements as in output
        String r = "";
        for (int i = 0; i < size; i++)
            r += (info[i] + " ");
        return r;
    }
}