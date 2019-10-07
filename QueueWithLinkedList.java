/**
Linked list implementation of Queue
*/
import java.util.*;
public class QueueWithLinkedList {

    private Node first, last;

    private class Node{
        String item;
        Node next;
    }
    public boolean isEmpty()
    { return first == null;}

    public void enqueue(String item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
    }

    public String dequeue(){
        if(isEmpty()){
            String s = "Queue is empty";
            return s;
        }else{
            String item = first.item;
            first = first.next;
            if(isEmpty()) last = null;
            return item;
        }
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        } else {
            Node nextNode = first;
            System.out.println("----OUT----");
            while(nextNode != null){
                String printItem = nextNode.item;
                System.out.println(printItem);
                nextNode = nextNode.next;
            }
            System.out.println("----IN----");
        }
    }

    public static void main(String [] args) {

        QueueWithLinkedList queue = new QueueWithLinkedList();
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
