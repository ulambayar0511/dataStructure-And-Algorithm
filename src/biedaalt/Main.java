package biedaalt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.SysexMessage;

import dataStructures.ArrayLinearList;

public class Main {
    // Нийт хичээлүүдийн жагсаалтыг харуулах
    public static void main(String[] args) throws IOException {
        Registration registration = new Registration();
        FileRead subjecFileRead = new FileRead("subject.txt");
        for (int i = 0; i < subjecFileRead.getArr().size(); i++) {
            Object[] arr = subjecFileRead.getArr().get(i);
            for (int j = 0; j < 3; j++) {
                System.out.println(arr[j]);
            }
        }
        // for (int i = 0; i < subjecFileRead.getArr().size(); i++) {

        // registration.setSubject(subjecFileRead.getArr().get(i), i);
        // }
        // for (int i = 0; i < subjecFileRead.getArr().size(); i++) {

        // System.out.println(registration.getSubject(i).getCode());
        // }
        // try {
        // BufferedReader input = new BufferedReader(new
        // FileReader("src/biedaalt/subject.txt"));
        // String line;
        // int index = 0;
        // while ((line = input.readLine()) != null) {

        // String values[] = line.split("/");
        // registration.setSubject(values, index);
        // index++;
        // }
        // System.out.println("Нийт хичээлүүдийн жагсаалт");
        // for (int i = 0; i < index; i++) {

        // System.out.println(registration.getSubject(i).getCode());
        // }
        // input.close();
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // System.out.println("File not found: " + "subject");
        // System.exit(1);
        // }
        // // Нийт мэргэжлүүдийн жагсаалтыг харуулах
        // try {
        // BufferedReader input = new BufferedReader(new
        // FileReader("src/biedaalt/Professions.txt"));
        // String line;
        // int index = 0;
        // while ((line = input.readLine()) != null) {

        // String values[] = line.split("/");
        // registration.setMajor(values, index);
        // index++;
        // }
        // System.out.println("Нийт мэргэжлүүдийн жагсаалт");
        // for (int i = 0; i < index; i++) {
        // System.out.println(registration.getMajor(i).getName());
        // }
        // input.close();
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // System.out.println("File not found: " + "Professions");
        // System.exit(1);
        // }
        // // Нийт оюутны дундаж голч дүнг харуулах
        // try {
        // BufferedReader input = new BufferedReader(new
        // FileReader("src/biedaalt/Exams.txt"));
        // String line;
        // int index = 0;
        // while ((line = input.readLine()) != null) {

        // String values[] = line.split("/");
        // registration.setStudent(values, index);
        // index++;
        // }
        // float sum = 0;
        // for (int i = 0; i < index; i++) {
        // sum += registration.getStudent(i).getGPA();
        // // System.out.println((registration.getStudent(i).getGPA()));
        // }
        // System.out.println("Нийт оюутны дундаж голч дүн: " + sum / index);
        // // Гураваас дээш хичээлд “F” үнэлгээ авссан хасагдах оюутны жагсаалт хэвлэх
        // System.out.println("Гураваас дээш хичээлд “F” үнэлгээ авссан хасагдах оюутны
        // жагсаалт");
        // for (int i = 0; i < index; i++) {
        // if (registration.getStudent(i).getGPA() < 0.7) {
        // System.out.println(registration.getStudent(i).getCode());
        // }
        // }

        // // Хичээл бүрээр оюутнуудын дүнгийн жагсаалтыг харуулах
        // System.out.println("Хичээл бүрээр оюутнуудын дүнгийн жагсаалтыг харуулах");

        // for (int i = 0; i < index; i++) {
        // System.out.print(registration.getStudent(i).getCode() + " : ");
        // for (int j = 0; j < registration.getStudent(i).getLessons().size(); j++) {
        // // Object subjectName =
        // // registration.getStudent(i).getLessons().get(j).getScore();
        // // System.out.println(registration.getStudent(i).getLessons());
        // System.out.println(registration.getStudent(i).getLessons().get(j));
        // }
        // }
        // System.out.println("Мэргэжил бүрээр оюутнуудын дүнгийн жагсаалтыг харуулах");
        // // for (int i = 0; i < )

        // input.close();
        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch blocki System.out.println("File not found: " +
        // // "Professions");
        // System.exit(1);
        // }
        // try {
        // BufferedReader input = new BufferedReader(new
        // FileReader("src/biedaalt/Exams.txt"));
        // String line;
        // int index = 0;
        // while ((line = input.readLine()) != null) {

        // String values[] = line.split("/");
        // registration.setStudent(values, index);
        // index++;
        // }
        // } catch (Exception e) {
        // // TODO: handle exception
        // }

    }
}
