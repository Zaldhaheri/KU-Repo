import java.util.*;

public class TreeType <E extends Comparable<? super E>> {  
    private BinaryNode<E>  root; 
    private static class BinaryNode<E> { //inner utility class used by BST
        public BinaryNode( E  theinfo ) { // Constructors
            this( theinfo, null, null );
        }
        public BinaryNode( E theinfo, BinaryNode<E> lt, BinaryNode<E> rt ) {
            info  = theinfo;
            left     = lt;
            right    = rt;
        }
        private E info;            		// The data in the node
        private BinaryNode<E> left;   	// Left child
        private BinaryNode<E> right;  	// Right child
    }
    public TreeType ( ) { 	    	// constructor 
        root = null ;
    }
    public boolean isEmpty( ) {
        return ( root == null ) ;
    }
    public void makeEmpty() {  // Destroy the Tree – garbage collector
        root = null; //This on its own will not deallocate the memory
    }
    public boolean getItem (E  item) {
        return getHelper( item, root ) ; // call a recursive utility method
    }
    private boolean getHelper( E x, BinaryNode<E> t ) { // or public
        if( t == null )  return false;    // item does not exist
        int compareResult = x.compareTo( t.info );         
        if( compareResult < 0 )          return getHelper( x, t.left ); // LEFT
        else if( compareResult > 0 )  return getHelper( x, t.right ); // RIGHT
        else  return true;    // FOUND A MATCH BINGO!!
    }
    public void addItem (E  item )  { 
        root = addHelper ( item, root ) ; 
    }
    private BinaryNode<E> addHelper( E x, BinaryNode<E> t ) {
        if( t == null )  return new BinaryNode<>( x, null, null ); //leaf
        int compareResult = x.compareTo( t.info );            
        if( compareResult < 0 )   t.left = addHelper( x, t.left ); // GO LEFT
        else if( compareResult > 0 )  t.right = addHelper( x, t.right ); //RIGHT
        else         ;  // Duplicate; do nothing   - line can be removed
        return t;
    }
    public void deleteItem(E x) {
        root = deleteHelper(x, root);
    }
    private BinaryNode<E> deleteHelper(E x, BinaryNode<E> t) {
        if( t == null ) {
            System.out.printf("Node %d is not found\n", x);
            return t;   // Item not found; do nothing
        }
        int compareResult = x.compareTo( t.info );
        if( compareResult < 0 ) t.left = deleteHelper( x, t.left );
        else if(compareResult>0) t.right = deleteHelper( x, t.right );
        else if(t.left != null && t.right != null) { // 2 children exist
            t.info = findMin( t.right ).info; // or findMax(t.left).info;
            t.right = deleteHelper( t.info, t.right ); //or t.left=…(…, t.left)
        } else t = ( t.left != null ) ? t.left : t.right; //1 child only
        return t;
    }
    //changed
    public void   printTree ( ) { 
	//change this method to print a message if the tree is empty
        if (isEmpty())
            System.out.println("Tree is empty");
        else
            printHelper(root);
    }
    public void printTreePost() {
	// implement this method based on the printTree
        if (isEmpty())
            System.out.println("Tree is empty");
        else
            printTreePost(root);
    }
    public void printTreePre() {
	// implement this method based on the printTree
        if (isEmpty())
            System.out.println("Tree is empty");
        else
            printTreePre(root);
    }
    public void printHelper ( BinaryNode<E> ptr) { // Print inorder/infix
        if (ptr != null) {
	        printHelper(ptr.left);	// Print left subtree
       	    System.out.print(ptr.info+ " ");		// Print the node			
	        printHelper(ptr.right);	// Print right subtree
        }
    } //same concept can be used for printTreePost or printTreePre 
    private void printTreePost( BinaryNode<E> ptr ) {
//implement this method based on the prntHelper for inorder
        if (ptr != null) {
	        printTreePost(ptr.left);	// Print left subtree
	        printTreePost(ptr.right);	// Print right subtree
       	    System.out.print(ptr.info+ " ");		// Print the node			
        }
    }
    private void printTreePre( BinaryNode<E> ptr ) {
//implement this method based on the prntHelper for inorder
        if (ptr != null) {
       	    System.out.print(ptr.info+ " ");		// Print the node			
	        printTreePre(ptr.left);	// Print left subtree
	        printTreePre(ptr.right);	// Print right subtree
        }
    }
    public E findMin( ) { //fix this method to avoid crashing when called on an empty tree
        if(isEmpty()) {
            System.out.println("FindMin Error: Tree is Empty");
            return null;
        }
        return findMin(root).info; // this line will crash your program if this method is called on an empty tree – fix it
    }
    private BinaryNode<E> findMin( BinaryNode<E> t ) { 
        if(t == null)  
            return null;
        else if(t.left == null)  
            return t; 
        return findMin(t.left); 
    }
    public E findMax( ) { 
	//implement this method based on findMin  and fix it as findMin
        if(isEmpty()) {
            System.out.println("FindMax Error: Tree is Empty");
            return null;
        }
        return findMax(root).info;
    }
        private BinaryNode<E> findMax( BinaryNode<E> t ) { 
            //implement this method based on findMin 
            if(t == null)  
                return null;
            else if(t.right == null)  
                return t; 
            return findMax(t.right); 
        }
    public int height() { //this method is not in the powerpoint lecture notes and added here to ease implementation
        //insert a line of code to call the other height method
        return height(root);
    }
    private int height( BinaryNode<E> t ) {
        if( t == null )
            return  -1;
        else
            return 1 + Math.max(height(t.left), height(t.right));    
    }
    public int length() { //this method is not in the powerpoint lecture notes and added here to ease implementation
        //insert a line of code to call the other length method
        return length(root);
    }
    private int length( BinaryNode<E> t ) { // or size (number of nodes)
        if(t == null)
            return 0;
        else
            return 1 + length( t.left )+ length( t.right );    
    }

    // same concept can be used for Sum of nodes. How????
    public int sumOfNodes()
    {
        return sumOfNodes(root);
    }

    private int sumOfNodes( BinaryNode<E> t ){ //can be also done in 2 methods as above but left like this to show difference
    //implement this recursive method to return the sum of nodes of the tree (by adding all the t.infos)
        if (t == null)
            return 0;
        else
            return (Integer) t.info + sumOfNodes(t.left) + sumOfNodes(t.right);
    }

    public static void main( String [ ] args ) {
    //implement the driver method
        TreeType<Integer> tree = new TreeType<>();
        int ID = 70;
        int[] arr = {50, 157, 171, 22, 18, 119, 139, 33, 75, 53, 92, 80, 51, 31, 11, ID};
        tree.printTree();
        
        System.out.println("Returned value from findMin: " + tree.findMin());
        System.out.println("Returned value from findMax: " + tree.findMax());

        for (int item : arr)
        {
            tree.addItem(item);
        }

        System.out.print("In Order: ");
        tree.printTree();
        System.out.print("\nPost Order: ");
        tree.printTreePost();
        
        
        tree.addItem(34);
        System.out.print("\nAfter adding node 34: ");
        tree.printTree();

        tree.deleteItem(22);
        System.out.print("\nAfter deleting node 22: ");
        tree.printTree();
        System.out.println();
        tree.deleteItem(97);
        System.out.print("After deleting node 97: ");
        tree.printTree();
        tree.deleteItem(70);
        System.out.print("\nAfter deleting node 70: ");
        tree.printTree();

        System.out.print("\nPre Order: ");
        tree.printTreePre();

        System.out.println("\nThe Min is " + tree.findMin() + ", the Max is " + tree.findMax());
        System.out.println("The height is " + tree.height() + ", the length is " + tree.length());
        System.out.println("The sum of nodes: " + tree.sumOfNodes());

        while(!tree.isEmpty())
        {
            System.out.print("After Deleting " + tree.root.info + ":");
            tree.deleteItem(tree.root.info);
            tree.printTree();
            System.out.println();

        }
    }    
}
