package biedaalt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dataStructures.ArrayLinearList;

public class FileRead {
    public ArrayLinearList arr = new ArrayLinearList();
    private String filename;

    public FileRead(String filename) {
        this.filename = filename;
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/biedaalt/" + this.filename));
            String line;
            int index = 0;
            while ((line = input.readLine()) != null) {
                String values[] = line.split("/");
                arr.add(index, values);
                index++;
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found: " + "subject");
            System.exit(1);
        }
    }

    public ArrayLinearList getArr() {
        return this.arr;
    }

}
