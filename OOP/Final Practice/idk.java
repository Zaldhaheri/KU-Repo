public class idk{
    public static void main(String[] args){
        int[] list = {8,1,2,4,6,5,9,0,3,7,100,-1};
        int index;
        int length = list.length;
        int minIndex;
        int smallestIndex;
        int temp;
        for (index = 0; index <length; index++){
            smallestIndex = index;
            for(minIndex = index + 1; minIndex<length; minIndex++){
                if (list[minIndex] < list[smallestIndex]){
                    smallestIndex = minIndex;
                }
            }
            temp = list[smallestIndex];
            list[smallestIndex] = list[index];
            list[index] = temp;
        }
        for (index = 0; index<length; index++){
            System.out.print(list[index] + " ");
        }
    }
}