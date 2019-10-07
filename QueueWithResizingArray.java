/**
 *Queue with resizing array
 */

import java.util.Scanner;
public class QueueWithResizingArray {
     private String []s = new String[1];
     private int N = 0;
     private int head = 0;
     private int tail = 0;

     public boolean isEmpty(){
         return N == 0;
     }

     public void enqueue(String item){
         if(N == s.length){
             resize(s.length*2);
         }
         s[tail++] = item;
         if(tail == s.length){
             tail = 0;
         }
         N++;
     }

     private void resize(int capacity){
         String []copy = new String[capacity];
         System.out.println("Resizing");
         for(int i=0;i<N;i++){
             copy[i] = s[(head+i)%s.length];
         }
         s = copy;
         head = 0;
         tail = N;
     }


    public String dequeue(){
         if(isEmpty()){
             String s = "Queue is empty";
             return s;
         }else{
             String item = s[head];
             s[head] = null;
             head++;
             N--;
             if(head == s.length){
                 head = 0;
             }
             if(N>0 && N < s.length/4){
                 resize(s.length/2);
             }
             return item;
         }
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }else{
            System.out.println("----OUT----");
            for(int i=0; i<N;i++){
                System.out.println(s[(head +i)%s.length]);
            }
            System.out.println("----IN----");
        }
        System.out.println("Array Size: "+ s.length);
    }

    public static void main(String [] args) {

        QueueWithResizingArray queue = new QueueWithResizingArray();
        boolean breakWhile = false;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.printf("Enter type of operation:  1)for enqueue  2)for dequeue  3) print  4)exit");
            try {
                int operation = Integer.parseInt(scan.nextLine());
                switch(operation) {
                    case 1:
                        System.out.printf("Enter a string to enqueue");
                        String inputString = scan.nextLine();
                        queue.enqueue(inputString);
                        break;
                    case 2:
                        String item = queue.dequeue();
                        System.out.println(item);
                        break;
                    case 3:
                        queue.print();
                        break;
                    case 4:
                        breakWhile = true;
                        break;
                    default:
                        System.out.println("Enter a valid operation");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid operation");
            }

            if(breakWhile){
                break;
            }
        }
    }
}
