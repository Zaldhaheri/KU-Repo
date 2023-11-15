public class Driver
{
    public static void main(String args[])
    {
        UnsortedType<Integer> List = new UnsortedType<>();
        UnsortedType<Integer> List2 = new UnsortedType<>();
        int[] arr = {22, 24, 11, 14, 8, 6};
        for (int i = 0; i < 6; i++)
        {
            List.addItem(arr[i]);
        }
        System.out.println("list has " + List.size() + " items: " + List);
        List.addItemLast(30);
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
        List2.addItemLast(27);
        List2.addItemLast(26);
        List2.addItemLast(22);
        System.out.println("List2 has " + List2.size() + " items: " + List2);
        List.mergeLists(List2);
        System.out.println("List after merging has " + List.size() + " items: " + List);
    }
}

public class UnsortedType<E> {
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
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size=0;
    public UnsortedType (){}
    public int size() { return size;}
    public boolean isEmpty(){return size==0;}
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    } 
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    } 
    public void addItem(E e) {
        head=new Node<>(e,head);
        if(size==0) tail=head;
        size++;
    }
    public void addItemLast(E e) {
        Node<E> newest=new Node<>(e,null);
        if(isEmpty()) head=newest;
        else tail.setNext(newest);
        tail=newest;
        size++;
    }
    public E deleteItem() {
        if(isEmpty()) return null;
        E answer = head.getElement();
        head=head.getNext();
        size--;
        if(size==0) tail=null;
        return answer;
    }
    public E deleteItem(E e) {
        if(isEmpty()) return null;
        E answer = head.getElement();
        Node<E> cur = head;
        Node<E> prev = null;
        boolean found = false;
        while(cur!=null) {
            answer=cur.getElement();
            if(e==answer) {
                found=true; 
                break;
            } else {
                prev=cur;
                cur=cur.next;    
            }     
        }
        if(found) {
            size--;
            if(size==0) {
                tail=null;
                head=null;
            } else {
                prev.next=cur.next;
                if(cur.next==null) tail=cur;
            }
            return answer;
        } else return null;
    }
    public E deleteItemLast() {
        if(isEmpty()) return null;
        E answer = tail.getElement();
        Node<E> prev = null;
        Node<E> current=head;
        while(current.next!=null) {
            prev=current;
            current=current.next;
        }
        if(prev==null) { // only one node exist in the list
            head=tail=null;
        } else {
            prev.setNext(null);
            tail=prev;
        }
        size--;
        return answer;
    }
    public String toString() {
        Node<E> cur = head;
        String s="";
        if(head!=null) {
            do{
                s+=cur.getElement()+ " ";
                cur=cur.next;
            }   while(cur!=null);
        }
        return s;
    }
    public boolean getItem(E e) {
        Node<E> cur = head;
        boolean found = false;
        if(head!=null) {
            do{
                if(e==cur.getElement()) {
                found = true;
                break;
                }
                cur=cur.next;
            }  while(cur.getNext()!=null);
        }
        return found;
    }
    
    public void mergeLists(UnsortedType ut) {
        //implement this method using a Node object that points to the head of the 
        //second list and then add the elements of this new list to the encapsulated 
        //list using the method addItem. After you add the element then you move the
        // object to the next one until you reach null
        @SuppressWarnings("unchecked")
        Node<E> N = ut.head;
        while (N != null)
        {
            addItem(N.getElement());
            N = N.next;
        }
    }
}//end of class UnsortedType 
