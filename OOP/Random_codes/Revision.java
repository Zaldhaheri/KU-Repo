public class Revision{
    public static int[] reverse(int[] b){
        int[] antiball = new int[b.length];
        for (int i = 0 ; i<b.length ; i++){
            antiball[i] = b[b.length-1-i];
        }
        return antiball;
    }
    public static void Display(int[] b){
        for (int i : b){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean search(int[] a, int s){
        for (int i : a){
            if(i == s) return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] ball = new int[]{1,2,3,4,5};
        Display(reverse(ball));
        System.out.println(search(ball,6));
    }
}

