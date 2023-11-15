public class ball{
    public static void main(String[] args){ 
        int[] a = {3,5,7};
        int[] b = {2,4,6};
        int[] r;
        r = mergeSorted(a,b);
        for (int i = 0; i<r.length; i++){
            System.out.print(r[i] + " ");
        }
    }
    public static int[] mergeSorted(int[] a, int[] b){
        int length = a.length + b.length;
        int[] r = new int[length];
        int temp;
        for(int i = 0; i<a.length; i++){
            r[i] = a[i];
        }
        for(int i = 0; i<b.length; i++){
            r[a.length + i] = b[i];
        }

        boolean sorted;
        do{
            sorted = true;
            for(int i = 0; i<r.length - 1; i++){
                if(r[i]>r[i+1]){
                    temp = r[i];
                    r[i] = r[i+1];
                    r[i+1] = temp;
                    sorted = false;
                }
            }
        }while(!sorted);

        return r;
    }
}
