import dataStructures.LinkedStack;
import java.util.Scanner;

public class MyStack extends LinkedStack {
    MyStack(int iniSize) {
        super(iniSize);
    }

    MyStack() {
        super();
    }

    static MyStack myStack = new MyStack();

    // private int size() {

    // MyStack tmpStack = new MyStack();
    // while (!tmpStack.empty()) {
    // tmpStack.pop();
    // size++;
    // }
    // System.out.println(myStack.empty());
    // return size;

    // }
    int size() {
        return size;
    }

    private static void inputStack() {
        myStack.push("asdfasdf");
        myStack.push("asdfasdfzx");
        myStack.push("qwerqwerqwer");
        myStack.push("dfgjfhfjh");
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Та оруулах стекийн хэмжээг оруулна уу ?");
        // int stackSize = scan.nextInt();
        // for (int i = 0; i < stackSize; i++) {
        // myStack.push(scan.next());
        // }

        // scan.close();
    }

    static int tmpSize = myStack.size() / 2;
    static MyStack splitStack = new MyStack();

    static void splitStack() {
        // mystack utgiin talig splitStack-d utgiig onoono
        if (myStack.size() == 2)
            return;
        Object top = myStack.peek();
        myStack.pop();

        splitStack();
        splitStack.push(top);

    }

    private static void combineStack() {
        // umne huwasan splitStack bolon myStack negtgeh bolno.
        while (!splitStack.empty()) {
            myStack.push(splitStack.pop());
        }
    }

    static void PrintStack(MyStack myStack) {

        // If stack is empty then return
        if (myStack.empty())
            return;
        Object top = myStack.peek();
        myStack.pop();
        PrintStack(myStack);
        System.out.print(top + " ");
        myStack.push(top);
    }

    public static void main(String[] args) {

        inputStack();
        PrintStack(myStack);
        splitStack();
        PrintStack(splitStack);
        PrintStack(myStack);
        combineStack();
        PrintStack(myStack);
        // System.out.println(myStack.printStack());
    }

}
