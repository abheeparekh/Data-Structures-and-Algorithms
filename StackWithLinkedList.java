/**
 Linked list implementation of Stack
 */
import java.util.*;

public class StackWithLinkedList {

    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop(){
        if(isEmpty()){
            String s = "Stack is empty";
            return s;
        }else{
            String item = first.item;
            first = first.next;
            return item;
        }
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        } else{
            Node nextNode = first;
            System.out.println("----Top----");
            while(nextNode != null){
                String printItem = nextNode.item;
                System.out.println(printItem);
                nextNode = nextNode.next;
            }
            System.out.println("----Bottom----");
        }
    }

    public static void main(String [] args){
        StackWithLinkedList stack = new StackWithLinkedList();
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
            catch (Exception e){
                System.out.println("Please enter a valid operation");
            }

            if(breakWhile){
                break;
            }

        }
    }
}
