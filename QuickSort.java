/**
 * QuickSort
 */

import java.util.Scanner;

public class QuickSort {
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a){
        for(int i=1; i<a.length; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
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

    private static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
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
        sortCompleted = isSorted(a);
        System.out.println("Is the array sorted: " + sortCompleted);
        sort(a);
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
        sortCompleted = isSorted(a);
        System.out.println("Is the array sorted: " + sortCompleted);
    }
}
