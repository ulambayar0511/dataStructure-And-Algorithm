import java.util.Scanner;

import dataStructures.*;

public class MyArrayLinearList extends ArrayLinearList {
    // min,max ,sum,average,sort,removeOdd
    static int maxElement(ArrayLinearList arr) {
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if ((int) arr.get(i) > max)
                max = (int) arr.get(i);

        }
        return max;
    }

    static int minElement(ArrayLinearList arr) {
        int min = 0;
        for (int i = 0; i < arr.size(); i++) {
            if ((int) arr.get(i) < min)
                min = (int) arr.get(i);

        }
        return min;
    }

    static void removeOdd(ArrayLinearList arr) {

        for (int i = 0; i < arr.size(); i++) {
            if ((Integer) arr.get(i) % 2 == 1)
                arr.remove(i);
        }
    }

    static int sumArr(ArrayLinearList arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += (Integer) arr.get(i);

        }
        return sum;
    }

    // selection sort
    static void sortArr(ArrayLinearList arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {

                if ((Integer) arr.get(min) > (Integer) arr.get(j))
                    min = j;
            }

            int a = (Integer) arr.get(min);
            int b = (Integer) arr.get(i);
            arr.remove(min);
            arr.add(min, b);
            arr.remove(i);
            arr.add(i, a);

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("list size:");
        int size = scan.nextInt();
        ArrayLinearList List = new ArrayLinearList(size);
        for (int i = 0; i < size; i++) {
            System.out.print("input element of list :");
            List.add(i, scan.nextInt());
            System.out.println();
        }
        while (true) {
            System.out.print(
                    "1.Sorting\n2.Max element\n3.Min element\n4.Remoce odd elements\n5.Average of total elements\ninput option:");
            try {

                int option;
                option = scan.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Sorting before:");
                        System.out.println(List.toString());

                        sortArr(List, size);
                        System.out.println("Sorting after:");
                        System.out.println(List.toString());
                        break;
                    case 2:
                        int max = maxElement(List);
                        System.out.println("Max :" + max);
                        break;
                    case 3:
                        int min = minElement(List);
                        System.out.println("Min :" + min);
                        break;
                    case 4:
                        System.out.println(List.toString());
                        removeOdd(List);
                        System.out.println(List.toString());
                        break;
                    case 5:
                        int sum = sumArr(List);
                        double average = sum / List.size();
                        System.out.println("Average :" + average);
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
    }
}
