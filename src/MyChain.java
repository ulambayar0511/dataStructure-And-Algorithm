import java.util.Scanner;

import dataStructures.Chain;

public class MyChain extends Chain {
    // max length 100
    static Chain chain = new Chain();

    static void printLinkedList() {
        for (int i = 0; i < chain.size(); i++) {
            System.out.println(chain.get(i));
        }
    }

    static void printLinkedList(MyChain myChain) {
        for (int i = 0; i < myChain.size(); i++) {
            System.out.println(myChain.get(i));
        }
    }

    // Жагсаалтыг массив рүү хөрвүүлж буцаана.
    public Object[] toArray() {
        Object[] arr = new Object[chain.size()];
        for (int i = 0; i < chain.size(); i++) {
            arr[i] = chain.get(i);
        }
        return arr;
    }

    // Өгөгдсөн элементүүдийг жагсаалтын ард нэмнэ.
    public void addRange(Object[] elements) {

        for (int i = 0; i < elements.length; i++) {
            chain.add(chain.size(), elements[i]);
        }
    }

    private boolean checkElement(Object object) {
        for (int i = 0; i < chain.size(); i++) {
            if (object.equals(chain.get(i)))
                return false;
        }
        return true;
    }

    // Өгөгдсөн жагсаалт болон үндсэн жагсаалт ын нэгдэл жагсаалтыг буцаана.
    public MyChain union(MyChain myChain) {
        MyChain tmpChain = new MyChain();
        for (int i = 0; i < chain.size(); i++) {
            tmpChain.add(i, chain.get(i));
        }
        for (int i = 0; i < myChain.size(); i++) {
            if (checkElement(myChain.get(i))) {
                tmpChain.add(chain.size(), myChain.get(i));
            }
        }
        return tmpChain;
    }

    // Өгөгдсөн жагсаалт болон үнсэн жагсаалтын огтлолцол жагсаалтыг буцаана
    public MyChain intersection(MyChain myChain) {
        MyChain tmpChain = new MyChain();
        for (int i = 0; i < myChain.size(); i++) {
            if (!checkElement(myChain.get(i))) {
                tmpChain.add(i, myChain.get(i));
            }
        }
        return tmpChain;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Program started");
        chain.add(0, 4);
        chain.add(1, 2);
        chain.add(2, 9);
        MyChain myChain = new MyChain();
        myChain.add(0, 1);
        myChain.add(1, 5);

        while (true) {
            System.out.print("1.toArray\n2.addRange\n3.union4.\ninput option:");
            int option;
            option = scan.nextInt();
            switch (option) {
                case 1:
                    Object arr[] = myChain.toArray();
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                    break;
                case 2:
                    Object[] addElements = { 1, 2, 3 };
                    myChain.addRange(addElements);
                    printLinkedList();
                    break;
                case 3:
                    myChain = myChain.union(myChain);
                    printLinkedList(myChain);
                    break;
                case 4:
                    myChain = myChain.intersection(myChain);
                    printLinkedList(myChain);
                    break;
                default:
                    System.out.println("invalid input, input options 1 to 4 !!!");
            }
            System.out.print("do yo want to exit? yes or no:");
            String exit = new String();
            exit = scan.next();
            if (exit.equals("yes"))
                break;
        }
        System.out.println("Program finished");
        scan.close();
    }

}
