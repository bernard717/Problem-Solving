import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue{
        Stack<Integer> first;
        Stack<Integer> second;
        public MyQueue(){
            this.first = new Stack<>();
            this.second = new Stack<>();
        }
        public void enqueue(int x){
            first.push(x);
        }
        public int dequeue(){
            if(second.isEmpty()){
                while(!first.isEmpty())
                    second.push(first.pop());
            }
            return second.pop();
        }
        public int peek(){
            if(second.isEmpty()){
                while(!first.isEmpty())
                    second.push(first.pop());
            }
            return second.peek();
        }
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
