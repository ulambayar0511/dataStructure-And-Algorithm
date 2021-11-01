package biedaalt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import dataStructures.Chain;

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
            System.out.println("Нийт хичээлүүдийн жагсаалт");
            for (int i = 0; i < index; i++) {

                System.out.println(registration.getSubject(i).getCode());
            }
            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found: " + "subject");
            System.exit(1);
        }
        // Нийт мэргэжлүүдийн жагсаалтыг харуулах
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biedaalt/Professions.txt"));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null) {

                String values[] = line.split("/");
                registration.setMajor(values, index);
                index++;
            }
            System.out.println("Нийт мэргэжлүүдийн жагсаалт");
            for (int i = 0; i < index; i++) {
                System.out.println(registration.getMajor(i).getName());
            }
            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found: " + "Professions");
            System.exit(1);
        }
        // Нийт оюутны дундаж голч дүнг харуулах
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biedaalt/Exams.txt"));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null) {

                String values[] = line.split("/");
                registration.setStudent(values, index);
                index++;
            }
            float sum = 0;
            for (int i = 0; i < index; i++) {
                sum += registration.getStudent(i).getGPA();
                // System.out.println((registration.getStudent(i).getGPA()));
            }
            System.out.println("Нийт оюутны дундаж голч дүн: " + sum / index);
            // Гураваас дээш хичээлд “F” үнэлгээ авссан хасагдах оюутны жагсаалт хэвлэх
            System.out.println("Гураваас дээш хичээлд “F” үнэлгээ авссан хасагдах оюутны жагсаалт");
            for (int i = 0; i < index; i++) {
                if (registration.getStudent(i).getGPA() < 0.7) {
                    System.out.println(registration.getStudent(i).getCode());
                }
            }

            // Хичээл бүрээр оюутнуудын дүнгийн жагсаалтыг харуулах
            System.out.println("Хичээл бүрээр оюутнуудын дүнгийн жагсаалтыг харуулах");

            for (int i = 0; i < index; i++) {
                System.out.print(registration.getStudent(i).getCode() + " : ");
                Chain tmpchain = registration.getStudent(i).getLessons();
                for (int j = 0; j < registration.getStudent(i).getLessons().size(); j++) {
                    Lessons tmpLessons = (Lessons) tmpchain.get(j);
                    System.out.println(tmpLessons.getLearned().getCode() + " " + tmpLessons.getScore());
                }
            }
            System.out.println("Мэргэжил бүрээр оюутнуудын дүнгийн жагсаалтыг харуулах");

            for (int i = 0; i < index; i++) {
                System.out.print(registration.getStudent(i).getMajor() + " : ");
                Chain tmpchain = registration.getStudent(i).getLessons();
                for (int j = 0; j < registration.getStudent(i).getLessons().size(); j++) {
                    Lessons tmpLessons = (Lessons) tmpchain.get(j);
                    System.out.println(tmpLessons.getLearned().getCode() + " " + tmpLessons.getScore());
                }
            }

            input.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found: " + "Professions");
            System.exit(1);
        }

    }
}
