public class Q2{
    public static void main(String[] args){
        int[] array = {22, 17, 3, 8, 14, 29, 31, 2, 10, 26};
        int temp;
        int location;

        // for(int i = 1; i<array.length; i++){
        //     if(array[i]<array[i-1]){
        //         temp = array[i];
        //         location = i;
        //         do{
        //             array[location] = array[location - 1];
        //             location--;
        //         }while(location>0 && array[location - 1] > temp);
        //         array[location] = temp;
        //     }
        // }

        for(int i = 0; i<array.length; i++){
            for(int j = i + 1; j<array.length; j++){
                if (array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        boolean sorted;
        do{
            sorted = true;
            for(int i = 0; i<array.length - 1; i++){
                if(array[i]>array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }while(!sorted);

        for (int i = 0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}