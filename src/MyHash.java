import java.util.Scanner;

public class MyHash extends dataStructures.HashTable {
    static Scanner scan = new Scanner(System.in);
    static MyHash myhash;

    public MyHash(int divisor) {
        super(divisor);
    }

    void print(Object object) {
        System.out.println(object);
    }

    public void mySearch(Object key) {
        if (searchKey(key)) {
            print("Та хайсан түлхүүр хүснэгтэнд байна");
        } else {
            print("Та хайсан түлхүүр хүснэгтээс олдсонгүй :(");
        }
    }

    public void remove() {
        print("Та гараас устгах түлхүүрээ оруулна уу:");
        Object key = scan.next();
        if (searchKey(key)) {
            myhash.put(key, null);
        } else {
            print("Та устгах элементийн түлхүүр олдсонгүй :(");
        }

    }

    public void insert() {
        print("Та гараас түлхүүрээ оруулна уу:");
        Object key = scan.next();
        print("Та гараас элемэнтээ утгаа оруулна уу:");
        Object element = scan.next();
        myhash.put(key, element);
    }

    public void edit() {
        print("Та гараас өөрчлөх элемэнтийн түлхүүрийн утггыг оруулна уу:");
        Object key = scan.next();
        print("Та гараас өөрчлөх элемэнтээ оруулна уу:");
        Object element = scan.next();

        if (searchKey(key)) {
            myhash.put(key, element);
        } else {
            print("Таны өөрчлөх элементийн түлхүүр олдсонгүй :(");
        }
    }

    public static void main(String[] args) {
        System.out.print("size:");
        // print("size:");
        int size = scan.nextInt();

        myhash = new MyHash(size);

        while (true) {
            System.out.print(
                    "1.add\n2.remove\n3.edit\n4.output\n5.get element by key\n6.check to exist key\ninput option:");
            int option;
            try {

                option = scan.nextInt();

                switch (option) {
                case 1:
                    myhash.insert();
                    break;
                case 2:
                    myhash.remove();
                    break;
                case 3:
                    myhash.edit();
                    break;
                case 4:
                    myhash.output();
                    break;
                case 5:
                    myhash.print("Та түлхүүрийн утгаа оруулна уу:");
                    Object key = scan.next();
                    myhash.print(myhash.get(key) == null ? "Та оруулсан элемэнт олдсонгүй :(" : myhash.get(key));
                    break;
                case 6:
                    myhash.print("Та хайх түлхүүрийн утгаа оруулна уу:");
                    Object searchkey = scan.next();
                    myhash.mySearch(searchkey);
                    break;
                default:
                    System.out.println("invalid input, input options 1 to 4 !!!");
                }
            } catch (Exception exception) {
                System.out.println("invalid input, input options 1 to 4 !!!");
            }
            System.out.print("do you want to exit? yes or no:");
            String exit = scan.next();
            if (exit.equals("yes"))
                break;
        }

    }

}
