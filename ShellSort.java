/**
 * Shell Sort
 */
import java.util.Scanner;
public class ShellSort {
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

    public static void ShellSort(Comparable[] a){
        int N = a.length;
        int h =1;
        while(h<N/3){
            h = 3*h+1;
        }
        while(h>=1){
            for(int i =h;i<N;i++){
                for(int j=i;j>=h;j-=h){
                    if(less(a[j], a[j-h])){
                        exch(a, j, j-h);
                    }
                }
            }
            h = h/3;
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
        ShellSort(a);
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
        sortCompleted = isSorted(a);
        System.out.println("Is the array sorted: " + sortCompleted);
    }
}
