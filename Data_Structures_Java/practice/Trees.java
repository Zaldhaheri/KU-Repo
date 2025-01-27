public class Main
{
    public static void main(String[] args)
    {

    }
}

public class TreeType<E extends Comparable<? super E>>
{
    public static class BinaryNode<E> //create node
    {
        private E info; //data stored in node
        private BinaryNode<E> left; //pointer to left node
        private BinaryNode<E> right; //pointer to right node
        public BinaryNode(E theInfo) //constructor for node
        {
            this(theInfo, null, null);
        }
        public BinaryNode(E theInfo, BinaryNode<E> lt, BinaryNode<E> rt) //constructor for node
        {
            info = theInfo;
            left = lt;
            right = rt;
        }
    }
    private BinaryNode<E> root; //root node at the top
    public TreeType() //constructor for tree
    {
        root = null;
    }
    public boolean isEmpty() //checks if the tree is empty
    {
        return root == null;
    }
    public boolean getItem(E item)//return the result of get item helper
    {
        return getItemHelper(item, root);//passes the item and root to the recursive function
    }
    private boolean getItemHelper(E x, BinaryNode<E> t)//recusrive
    {
        if (t == null)//base condition for end of a tree
            return false;
        int compareResult = x.compareTo(t.info); //compare x to t.info
        if (compareResult < 0)// if x is less than t.info
            return getItemHelper(x, t.left); //recursive x and left part of the tree
        else if(compareResult > 0) //if x is greater than t.info
            return getItemHelper(x, t.right);//recursive x and right part of the tree
        else
            return true;// when x is found in tree returns 0
    }
    public BinaryNode<E> addItem(E item) //add item in the tree
    {
        return addItemHelper(item, root);//recursive function takes the item and root
    }
    private BinaryNode<E> addItemHelper(E x, BinaryNode<E> t)
    {
        if (t == null) //base case and position for new leaf found
            return new BinaryNode<>(x, null, null); //returns the new node
        int compareResult = x.compareTo(t.info); //compares x and t.info
        if (compareResult < 0) //if x is less than t.info
            t.left = addItemHelper(x, t.left); //t.left points to the new node or old node on the left
        else if (compareResult > 0) //if x is greater than t.info
            t.right = addItemHelper(x, t.right); //t.right points to the new or old noode to the right
        return t; //returns itself since item is already there
    }
    public BinaryNode<E> deleteItem(E item)
    {
        return deleteItemHelper(item,root);
    }
    private BinaryNode<E> deleteItemHelper(E x, BinaryNode<E> t)
    {
        if (t == null)
        {
            System.out.println("item not found");
            return t;
        }
        int compareResult = x.compareTo(t.info);
        if (compareResult < 0)
            t.left = deleteItemHelper(x, t.left);
        else if (compareResult > 0)
            t.right = deleteItemHelper(x, t.right);
        else if (t.left != null && t.right != null)
        {
            t.info = findMin(t.right).info;
            t.right = deleteItemHelper(t.info, t.right);
        }
        else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }
    public E findMin()
    {
        if (isEmpty()) 
            System.out.println("tree is empty");
        return findMin(root).info;
    }
    private BinaryNode<E> findMin(BinaryNode<E> t)
    {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }
    private int height(BinaryNode<E> t)
    {
        if (t == null)
            return -1;
        return 1 + Math.max(height(t.left),height(t.right));
    }
    private int length(BinaryNode<E> t)
    {
        if (t == null)
            return -1;
        return 1 + length(t.left) + length(t.right);
    }
    public void makeEmpty()
    {
        root = null;
    }
}