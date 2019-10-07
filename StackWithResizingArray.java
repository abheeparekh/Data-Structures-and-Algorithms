/**
 Stack with Resizing array
 */

import java.util.Scanner;
public class StackWithResizingArray {

    private String [] s = new String[1];
    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        if(N == s.length){
            resize(2*s.length);
        }
        s[N++] = item;
    }

    private void resize(int capacity){
        String [] copy = new String[capacity];
        for(int i=0;i<N;i++){
            copy[i] = s[i];
        }
        s=copy;
    }

    public String pop(){
        if(isEmpty()){
            String s = "Stack is empty";
            return s;
        }else{
            String item = s[--N];
            s[N] = null;
            if(N>0 && N==s.length/4){
                resize(s.length/2);
            }
            return item;
        }
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            System.out.println("----Top----");
            for(int i=N-1; i>=0;i--){
                System.out.println(s[i]);
            }
            System.out.println("----Bottom----");
        }
        System.out.println("Array Size: "+ s.length);
    }

    public static void main(String [] args){
        StackWithResizingArray stack = new StackWithResizingArray();
        boolean breakWhile = false;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.printf("Enter type of operation:  1)for push  2)for pop 3)for print 4)exit");

            try{
                int operation = Integer.parseInt(scan.nextLine());
                switch(operation){
                    case 1:
                        System.out.printf("Enter a string to push to stack");
                        String inputString = scan.nextLine();
                        stack.push(inputString);
                        break;
                    case 2:
                        String item = stack.pop();
                        System.out.println(item);
                        break;

                    case 3:
                        stack.print();
                        break;

                    case 4:
                        breakWhile = true;
                        break;

                    default:
                        System.out.println("Enter a valid operation");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Please enter a valid operation");

            }
            if(breakWhile){
                break;
            }

        }

    }
}
