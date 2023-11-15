import java.lang.*;

public class Main {
    private static int count = 1;
    private static int N = 12;
    private static int position[] = new int[N];

    public static boolean is_Queen_Safe(int queen, int row) {
        for (int i = 0; i < queen; i++) {
            int other_row = position[i];
            if (other_row == row || other_row == row - (queen - i) || other_row == row + (queen - i))
                return false;
        }
        return true;
    }

    public static void printSolution() {
        System.out.print("Solution " + count + ":");
        for (int q = 0; q < N; q++)
        {
            System.out.print(" " + position[q]);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (position[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solve(int k) {
        if (k == N) {
            printSolution();
            count++;
        } else {
            for (int i = 0; i < N; i++) {
                if (is_Queen_Safe(k, i)) {
                    position[k] = i;
                    solve(k + 1);
                }
            }
        }
    }

    public static void main(String args[]) {
        long t1 = System.nanoTime();
        solve(0);
        long t2 = System.nanoTime();
        double time = (double) (t2 - t1) / 1000000;
        System.out.println("Time: " + time + " ms");
    }
}
