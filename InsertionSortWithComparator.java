/**
 * Insertion Sort with Comparator interface
 */
/*
import java.util.Comparator;
import java.util.Scanner;

public class InsertionSortWithComparator implements Comparator <InsertionSortWithComparator>{

    String str;
    int num;

    InsertionSortWithComparator(String str, int num){
        this.str = str;
        this.num = num;
    }

    private static boolean less(Comparator c, Object v, Object w){
        return c.compare(v,w) <0;
    }

    private static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparator c, Object[] a){
        for(int i=1; i<a.length; i++){
            if(less(c, a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void sort(Object[]a, Comparator comparator){
        int N = a.length;
        for(int i =0; i<N; i++){
            for(int j=i; j>0 && less(comparator,a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        boolean sortCompleted = false;

        System.out.println("Enter number of strings to sort");
        int n = Integer.parseInt(scan.nextLine());
        Object [] a = new Object[n];
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
*/