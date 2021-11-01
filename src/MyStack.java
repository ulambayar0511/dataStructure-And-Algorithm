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
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "0.Гараас оруулсан стекийг хэвлэж харна.\n1.Стекийн санамсаргүйгээр хольж буцаана.\n2Стекийн элементүүдийн давхардлыг арилгаж буцаана.");
            System.out.println(
                    "3.массивийн элементүүдийг стек рүү хийнэ.\nСтекийн элементүүдийг массив байдлаар буцаана.");

            try {

                int option;
                option = scan.nextInt();

                switch (option) {
                case 0:
                    inputStack();
                    PrintStack(myStack);
                    break;
                case 1:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("invalid input, input options 1 to 5 !!!");
                    break;
                }
            } catch (Exception exception) {
                System.out.println("invalid input, input options 1 to 5 !!!");
            }
            System.out.print("do yo want to exit? yes or no:");
            String exit = new String();
            exit = scan.next();
            if (exit.equals("yes"))
                break;

        }
        scan.close();

        combineStack();
        PrintStack(myStack);
        // System.out.println(myStack.printStack());
    }

}
