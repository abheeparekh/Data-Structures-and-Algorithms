/**
 * Quick Select
 */

import java.util.Scanner;

public class QuickSelect {

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static int partition(Comparable[]a, int lo, int hi){
        int i =lo;
        int j = hi+1;
        while(true){
            while(less(a[++i], a[lo])){
                if(i==hi){ break; }
            }
            while(less(a[lo], a[--j])){
                if(j==lo){break;}
            }
            if(i>=j){break;}
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private static Comparable select(Comparable[]a, int k){
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length-1;
        while(hi>lo){
            int j = partition(a,lo,hi);
            if(j<k) lo = j+1;
            else if(j>k) hi = j-1;
            else return a[k];
        }
        return a[k];
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        boolean sortCompleted = false;
        System.out.println("Enter number of strings to sort");
        int n = Integer.parseInt(scan.nextLine());
        String [] a = new String[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter element");
            a[i] = scan.nextLine();
        }

        System.out.println("Enter the index k for QuickSelect");
        int k = Integer.parseInt(scan.nextLine());
        Comparable r = select(a,k);
        System.out.println("Result: "+ r);
    }
}
