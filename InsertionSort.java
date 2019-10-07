/**
 * Insertion Sort
 */

import java.util.Scanner;

public class InsertionSort {

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

    public static void InsertionSort(Comparable []a){
        for(int i=0;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(less(a[j], a[j-1])){
                    exch(a,j,j-1);
                }
            }
        }
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
        InsertionSort(a);
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
        sortCompleted = isSorted(a);
        System.out.println("Is the array sorted: " + sortCompleted);
    }
}
