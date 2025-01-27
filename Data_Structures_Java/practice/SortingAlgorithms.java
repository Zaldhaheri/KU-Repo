public class Main
{
    public static void main(String[] args)
    {
        SortingAlgorthims sort = new SortingAlgorthims();
        sort.addItem(21);
        sort.addItem(40);
        sort.addItem(83);
        sort.addItem(18);
        sort.addItem(5);
        sort.addItem(5);
        sort.addItem(94);
        sort.addItem(66);
        sort.addItem(31);
        sort.addItem(4);
        sort.print();
        sort.quickSort();
        sort.print();
    }
}

public class SortingAlgorthims
{
    private int[] data;
    private int size = 0;
    public SortingAlgorthims(){data = new int[20];}
    public void addItem(int n)
    {
        if (size < 20)
            data[size] = n;
        size++;
    }
    public void deleteItem(int n)
    {
        for (int i = 0; i < size; i++)
        {
            if (data[i] == n)
            {
                data[i] = data[size - 1];
                size--;
            }
        }
    }

    public void selectionSort()
    {
        int min; //look for min
        System.out.println("Selection Sort");
        for (int i = 0; i < size - 1; i++) //loop by i
        {
            min = i; //min at index i (standard)
            for (int j = i + 1; j < size; j++) //loop through the rest of the array
            {
                if (data[j] < data[min]) //if a new element is smaller than min
                    min = j;//new min index is j
            }
            if (min != i) //if no new min index found meaning min = i
            {
                int temp = data[min]; //swap
                data[min] = data[i];
                data[i] = temp;
            }
            System.out.print(i + " ");
            print();
        }
    }

    public void bubbleSort()
    {
        boolean sorted = false;
        int temp;
        for (int i = size - 1; (i >= 1) && (!sorted); i--)//loop from array size to index 1
        {
            sorted = true;//flag to make sure its sorted
            for (int j = 0; j < i; j++)//loop from index 0 to i - 1
            {
                if (data[j] > data[j + 1]) //check if the current element is greater than the next
                {
                    sorted = false;//flag, not sorted yet
                    temp = data[j]; //swap
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
                System.out.print(i + " ");
                print();
        }
    }

    public void quickSort()
    {
        quickSort(data, 0, size - 1);//recursive, pass array, first = 0 and last = array size - 1
    }

    private void quickSort(int A[], int F, int L)//recursive
    {
        int LastS1;
        int pivot;
        if (F < L)
        {
            pivot = A[F];//create a pivot at element F
            LastS1 = F;//Last Sort1 at F
            for (int FU = F + 1; FU <= L; FU++)//loop through FU to Last and look for element less than pivot
            {
                if (A[FU] < pivot)//if element less than pivot
                {
                    LastS1++;
                    swap(A, LastS1, FU);
                }
            }
            swap(A, LastS1, F);
            quickSort(A, F, LastS1-1);
            quickSort(A, LastS1 + 1, L);
        }
    }

    public void mergeSort()
    {
        mergeSort(data, 0, size-1);
    }
    public void mergeSort(int values[], int first, int last)
    {
        if (first < last)
        {
            int middle = (first + last) / 2;
            mergeSort(values, first, middle);
            mergeSort(values, middle + 1, last);
            merge(values, first, middle, middle + 1, last);
        }
    }

    public void merge(int values[], int lF, int lL, int rF, int rL)
    {
        int temp[] = new int[size];
        int index = lF, saveFirst = lF;
        while(lF<=lL && rF <= rL)
        {
            if(values[lF] < values[rF]) 
                temp[index++] = values[lF++];
            else
                temp[index++] = values[rF++];
        }
        while(lF <= lL)
        {
            temp[index++] = values[lF++];
        }
        while(rF <= rL)
        {
            temp[index++] = values[rF++];
        }
        for (index=saveFirst; index<=rL; index++)
        {
            values[index] = temp[index];
        }
    }

    public void heapSort()
    {
        heapSort(data, 3);
    }
    public void heapSort(int values[], int numValues)
    {
        int index;
        for (index = numValues/2 - 1; index >= 0; index--)
            reheapDown(values, index, numValues - 1);
        for (index = numValues - 1; index >= 1; index--){
            swap(values, 0, index);
            reheapDown(values, 0, index - 1);
        }
    }

    public void reheapDown(int values[], int root, int bottom)
    {
        int maxChild,rightChild,leftChild;
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        if (leftChild <= bottom)
        {
            if (leftChild == bottom)
                maxChild = leftChild;
            else{
                if (values[leftChild] <= values [rightChild])
                    maxChild = rightChild;
                else
                    maxChild = rightChild;
            }
            if (values[root] < values[maxChild])
            {
                swap (values, root, maxChild);
                reheapDown (values, maxChild, bottom);
            }
        }

    }

    public void swap(int A[], int a, int b)
    {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public void print()
    {
        if (size == 0)
            System.out.println("Empty");
        else
        {
            System.out.print("array: ");
            for (int i = 0; i < size; i++)
            {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }
}