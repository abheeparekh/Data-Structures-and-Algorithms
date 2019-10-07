/**
 * Merge Sort
 */

import java.util.Scanner;

public class MergeSort {

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a, int first, int last){
        for(int i=first+1; i<=last; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid +1, hi);
        for(int k=0;k<=hi; k++){
            aux[k] = a[k];      //copy
        }
        //merge
        int i=lo;
        int j = mid+1;
        for(int k=lo; k <=hi; k++){
            if(i>mid)                       a[k] = aux[j++];
            else if(j>hi)                   a[k] = aux[i++];
            else if(less(aux[j], aux[i]))   a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi<= lo)     return;
        int mid = lo + (hi-lo)/2;
        sort(a,aux, lo,mid);
        sort(a,aux, mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
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
