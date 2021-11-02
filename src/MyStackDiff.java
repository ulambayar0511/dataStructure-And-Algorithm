import dataStructures.LinkedStack;

import java.util.Random;
import java.util.Scanner;

import dataStructures.ArrayLinearList;

public class MyStackDiff extends LinkedStack {
    MyStackDiff(int iniSize) {
        super(iniSize);
    }

    MyStackDiff() {
        super();
    }

    static void PrintStack(MyStackDiff myStack) {

        // If stack is empty then return
        if (myStack.empty())
            return;
        Object top = myStack.peek();
        myStack.pop();
        System.out.print(top + " ");
        PrintStack(myStack);

        myStack.push(top);
    }

    int size() {
        return size;
    }

    static MyStackDiff myStack = new MyStackDiff();

    private static void inputStack() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Та оруулах стекийн хэмжээг оруулна уу ?");
        int stackSize = scan.nextInt();
        for (int i = 0; i < stackSize; i++) {
            System.out.println("стекийн элемэнтээ оруулна уу");
            myStack.push(scan.next());
        }

        scan.close();
    }

    public static MyStackDiff addRange(Object[] elements) {
        for (int i = 0; i < elements.length; i++) {
            myStack.push(elements[i]);
        }
        return myStack;
    }

    static boolean checkIn(ArrayLinearList arr, Object object) {
        for (int i = 0; i < arr.size(); i++) {
            if (object.equals(arr.get(i)))
                return true;
        }
        return false;
    }

    static Object[] toArray(MyStackDiff myStack) {
        Object[] tmp = new Object[myStack.size()];
        int index = 0;
        while (!myStack.empty()) {
            tmp[index] = myStack.pop();
            index++;
        }
        return tmp;
    }

    public static boolean exists(Object element) {
        ArrayLinearList arr = new ArrayLinearList();
        int index = 0;
        while (!myStack.empty()) {
            arr.add(index, myStack.pop());
            index++;
        }
        return checkIn(arr, element);
    }

    // Стекийн санамсаргүйгээр хольж буцаана.
    public static MyStackDiff unique() {
        ArrayLinearList aList = new ArrayLinearList(myStack.size());
        int index = 0;
        while (!myStack.empty()) {
            if (!checkIn(aList, myStack.peek())) {
                aList.add(index, myStack.pop());
                index++;
            }

            else {
                myStack.pop();
            }
        }
        for (int i = 0; i < aList.size(); i++) {
            myStack.push(aList.get(i));
        }
        return myStack;
    }

    public static MyStackDiff rand() {
        ArrayLinearList aList = new ArrayLinearList(myStack.size());
        int index = 0;
        while (!myStack.empty()) {
            aList.add(index, myStack.pop());
            index++;
        }
        while (index-- > 0) {
            // RAND CHOICE
            Random ran = new Random();
            int rand = index == 0 ? 0 : ran.nextInt(index);
            // int rand = (int) (Math.random() * index);
            myStack.push(aList.get(rand));
            aList.remove(rand);

        }
        return myStack;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int end = 1;

        while (true) {
            System.out.println(
                    "0.Гараас оруулсан стекийг хэвлэж харна.\n1.Стекийн санамсаргүйгээр хольж буцаана.\n2Стекийн элементүүдийн давхардлыг арилгаж буцаана.");
            System.out.println(
                    "3.массивийн элементүүдийг стек рүү хийнэ.\n4.Стекийн элементүүдийг массив байдлаар буцаана.");
            System.out.print("5.Гарахыг хүсвэл 5 сонгоно уу\ninput option:");
            int option;
            try {

                option = scan.nextInt();

                switch (option) {
                case 0:
                    inputStack();
                    PrintStack(myStack);
                    break;
                case 1:

                    inputStack();
                    System.out.println("random хийхийн өмнөх утга");
                    PrintStack(myStack);
                    rand();
                    System.out.println("random хийсний  дараах утга");
                    PrintStack(myStack);
                    break;
                case 2:
                    inputStack();

                    System.out.println("unique хийхийн өмнөх утга");
                    PrintStack(myStack);
                    unique();
                    System.out.println("unique хийсний  дараах утга");
                    PrintStack(myStack);

                    break;
                case 3:
                    inputStack();
                    System.out.println("add range  хийхийн өмнөх утга");
                    PrintStack(myStack);
                    Object[] elemeObjects = { "a", "b" };
                    System.out.println("add range хийсний  дараах утга");
                    addRange(elemeObjects);
                    PrintStack(myStack);
                    break;
                case 4:
                    inputStack();
                    PrintStack(myStack);
                    Object[] elements = toArray(myStack);
                    for (int i = 0; i < elements.length; i++) {
                        System.out.println(elements[i]);
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("invalid input, input options 0 to 4 !!!");
                    break;
                }
            } catch (Exception exception) {
                System.out.println("invalid input, input options 0 to 4 !!!");
            }

            // System.out.print("\ndo yo want to exit? yes or no:");

            // int exit = scan.nextInt();
            // if (exit == 1) {
            // break;
            // }

        }

    }

    private static void exit() {
    }

}
