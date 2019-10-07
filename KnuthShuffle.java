/**
 * Knuth Shuffle
 */

import java.util.*;
public class KnuthShuffle {

    private static void exch(String[] a, int i, int j){
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void KnuthShuffle(String[] a) {
        Random rand = new Random();
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(i + 1); //between 0 and i
            exch(a, i, r);
        }
    }
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of strings to shuffle");
        int n = Integer.parseInt(scan.nextLine());
        String [] a = new String[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter element");
            a[i] = scan.nextLine();
        }
        KnuthShuffle(a);
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }

    }
}
