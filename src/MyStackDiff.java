import dataStructures.LinkedStack;

import java.util.Random;

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
        myStack.push("a");
        myStack.push("b");
        myStack.push("a");
        myStack.push("d");
        // Scanner scan = new Scanner(System.in);
        // System.out.println("Та оруулах стекийн хэмжээг оруулна уу ?");
        // int stackSize = scan.nextInt();
        // for (int i = 0; i < stackSize; i++) {
        // myStack.push(scan.next());
        // }

        // scan.close();
    }

    public static MyStackDiff addRange(Object[] elements) {
        for (int i = 0; i < elements.length; i++) {
            myStack.push(elements[i]);
        }
        return myStack;
    }

    static boolean checkIn(ArrayLinearList arr, Object object) {
        for (int i = 0; i < arr.size(); i++) {
            if (object == arr.get(i))
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
            System.out.println(rand);
            myStack.push(aList.get(rand));
            aList.remove(rand);

        }
        return myStack;

    }

    public static void main(String[] args) {
        inputStack();
        // PrintStack(myStack);
        // rand();
        // PrintStack(myStack);
        // unique();
        // PrintStack(myStack);
        // Object[] elemeObjects = { "a", "b" };
        // addRange(elemeObjects);
        // PrintStack(myStack);
        // Object[] elements = toArray(myStack);
        // for (int i = 0; i < elements.length; i++) {
        // System.out.println(elements[i]);
        // }
        System.out.println(exists("a"));
    }

}
