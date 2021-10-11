package biedaalt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dataStructures.ArrayLinearList;

public class Main {
    // Нийт хичээлүүдийн жагсаалтыг харуулах
    public static void main(String[] args) throws IOException {
        Registration registration = new Registration();
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biedaalt/subject.txt"));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null) {

                String values[] = line.split("/");
                registration.setSubject(values, index);
                index++;
            }
            for (int i = 0; i < index; i++) {
                System.out.println(registration.getSubject(i).getCode());
            }
            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found: " + "subject");
            System.exit(1);
        }

        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biedaalt/Professions.txt"));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null) {

                String values[] = line.split("/");
                registration.setMajor(values, index);
                index++;
            }
            for (int i = 0; i < index; i++) {
                System.out.println(registration.getMajor(i).getName());
            }
            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found: " + "Professions");
            System.exit(1);
        }

    }
}
