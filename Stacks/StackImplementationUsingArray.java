import java.io.*;
import java.util.Scanner;

class StackImplementationUsingArray{
    static Scanner input = new Scanner(System.in);
    static int[] stack;
    static int top = -1;
    static int element = 0;

    public static void stk(int n){
        stack = new int[n];
    }

    public static void push(){
        if(top == stack.length-1){
            System.out.println("Stack is full");
        }
        else{
            for(int i = 0; i<stack.length; i++){
                System.out.println("Element to be pushed: ");
                element = input.nextInt();
                top += 1;
                stack[top] = element;
            }
        }
    }

    public static void pop(){
        if(top == -1){
            System.out.println("Stack is empty");
        }
        else{
            element = stack[top];
            top -= 1;
            System.out.println("Element popped: "+element);
        }
    }

    public static void display(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack elements are: ");
            for(int i=top;i>=0;i--){
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Enter the size of the stack: ");
        int n = input.nextInt();
        stk(n);
        push();
        display();
        pop();
        pop();
        pop();
        pop();
    }
}
