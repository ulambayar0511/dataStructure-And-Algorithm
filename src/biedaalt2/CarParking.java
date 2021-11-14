package biedaalt2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import dataStructures.LinkedStack;

public class CarParking extends LinkedStack {
    LinkedStack tmpStack = new LinkedStack(10);
    static CarParking cp = new CarParking();

    public CarParking() {
        super();
    }

    // Гаралтын болон оролтын машин хэвлэж харуулна.
    void output(Object object) {
        System.out.println(object);
    }

    // Машины гаралт оролтыг тооцоолно.
    public void process(String process, String number) {
        // process == A үед машин орох болно.
        if (process.equals("A")) {
            // Зогсоол дүүрсэн эсэхийг шалгана.
            if (cp.size == 10) {
                output("Зогсоол дүүрсэн байна.");
            } else {

                cp.push(number);
                output(number + " дугаартай машин " + cp.size + " эгнээнд амжилттай орлоо.");
            }
        } else {
            // process ==D ҮЕД зогсоолд орсон машин гарна.
            // гарах машиныг олтол давтана.
            while (!number.equals(cp.peek())) {
                // олдоогүй үед буцааж орох машинуудын утгыг хадгалж авна.
                tmpStack.push(cp.pop());

            }
            // олсон үед машиныг гаргаж хэвлэж харуулна.
            output(cp.pop() + " дугаартай машин  зогсоолийн " + (cp.size + 1) + "  эгнээнээс амжилттай  гарлаа.");
            // буцааж гарсан машинуудыг нэмнэ.
            while (!tmpStack.empty()) {
                cp.push(tmpStack.pop());
            }
        }
    }

    public void input() {
        // оролтыг файлаас уншина.
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biedaalt2/cars.txt"));
            String line;
            while ((line = input.readLine()) != null) {
                Car car = new Car();
                String values[] = line.split(" ");
                car.setProcess(values[0]);
                car.setNumber(values[1]);
                cp.process(car.getProcess(), car.getNumber());

            }

            input.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found: " + "cars.txt");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        cp.input();
    }
}
